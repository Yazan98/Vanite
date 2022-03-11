package io.vanite.android.utils.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*


/**
 * Created By : Yazan Tarifi
 * Date : 12/26/2019
 * Time : 10:13 PM
 */

object VaniteMapBuilder {

    fun createMapFromFragment(fragment: Fragment, id: Int): SupportMapFragment {
        return fragment.childFragmentManager.findFragmentById(id) as SupportMapFragment
    }

    fun getApiClient(
        context: Context,
        connectionListener: GoogleApiClient.ConnectionCallbacks
    ): GoogleApiClient {
        return GoogleApiClient.Builder(context)
            .addConnectionCallbacks(connectionListener)
            .addApi(LocationServices.API)
            .build()
    }

    fun createMapFromActivity(context: AppCompatActivity, id: Int): SupportMapFragment {
        return context.supportFragmentManager.findFragmentById(id) as SupportMapFragment
    }

    suspend fun addMarkerToMap(position: LatLng, mMap: GoogleMap, title: String, icon: Int) {
        withContext(Dispatchers.Main) {
            val markerOptions = MarkerOptions()
            markerOptions.position(position)
            mMap.clear()
            markerOptions.title(title)
            markerOptions.icon(BitmapDescriptorFactory.fromResource(icon))
            mMap.addMarker(markerOptions);
        }
    }

    suspend fun moveCamera(position: LatLng, mMap: GoogleMap, zoom: Float) {
        withContext(Dispatchers.Main) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, zoom))
        }
    }

    suspend fun activateAutoCompleteGoogleMaps(
        fragment: Fragment,
        id: Int,
        listener: AutoPlaceConfiguration
    ) {
        withContext(Dispatchers.Main) {
            val autocompleteFragment =
                fragment.childFragmentManager.findFragmentById(id) as AutocompleteSupportFragment
            autocompleteFragment.setPlaceFields(
                Arrays.asList(
                    Place.Field.ID,
                    Place.Field.NAME,
                    Place.Field.LAT_LNG
                )
            )
            autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
                override fun onPlaceSelected(p0: Place) {
                    p0.latLng?.let {
                        listener.onPlacePicked(it)
                    }
                }

                override fun onError(p0: Status) {
                    listener.onError(p0)
                }

            })
        }
    }

    interface AutoPlaceConfiguration {
        fun onPlacePicked(latLng: LatLng)
        fun onError(p0: Status)
    }

}
