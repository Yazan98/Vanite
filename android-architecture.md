---
description: Android Applications Overview
---

# Android Architecture

The Android Section has an Specific Structure To Build better , Optimized Applications , Multi Modular Applications

## Application Structure

The Vortex Applications Divided in 3 Layers \(UI , DATA , DOMAIN\) each layer has own Logic to divide the application logic this makes you build better, clean code

## Layers Description

UI Layer : This Layer is the User Interface Layer And This is the main layer at The Applications and includes \(Activities , Fragments\) as a main part of the project , The Secondary part is Notifications , Adapters, Dialogs , Application UI Configuration and so on everything will show the user some data

Data Layer : This layer has The Api Requests and Database Implementation , Shared Preferences each data implementation should be at this layer

Domain Layer : This Layer is The Logic layer at the application because this layer will tell the data layer to get the data and handle it to UI layer via State and the logic flow will describe later 

## Structure Description

State : Vortex handling Result Between Components as New State about ViewModel the ViewModel when Submit New Response as Success Response From ViewModel To View and View Don't Know anything about The State Just Apply The Incoming State From ViewModel , When Anything is Wrong The ViewModel should Submit Error State To View To show the user the error view or take an action about the error

Action : Vortex is Not Multi Direction Process because The ViewModel Just can Take Actions From View , The View Can Just Submit Actions to ViewModel and ViewModel Will Check the incoming Actions , Vortex is Just One Direction it's mean You Can Just talk to ViewModel Via Execute method just

Multi Threading : Each Method At Vortex is Suspend Function it means every process should execute on The Background Thread and reflect the Result To Main Thread to handle the UI

Api: Each Request At Vortex is Executed With RxJava and There are an Request Executors to execute the request with RxJava implementation , The RxJava Operations Supported is \(Observable , Single , Flowable , Maybe\)

UI Layer : The Primary Part at UI Layer is Fragments each Screen should be Fragment with Single Activity 

Domain Layer : The Primary Components at This Layer is ViewModels , State , Actions

Data layer : This Layer has The Apis, Crud Repositories , Shared Prefs , Local Database Implementation

## Application Flow

![Basic Flow At Application](.gitbook/assets/untitled-diagram.jpg)





