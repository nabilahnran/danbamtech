# Danbam-tech Bangkit Capstone Project 2021

Bangkit Academy B21-CAP0061 Capstone Project: Touchless Hospital Integrated Queuing System 

Danbam-tech
- A0050542 Jefry Chiedi (github: klaveriuzent)
- A1221565 Helga Agnizar (github: helgaagnizar)
- C0050483 Rizky Martin (github: RIzky-Martin)
- C0050516 Muhammad Rayyan (github: muhrayyan)
- M0050427 Galuh Putra Warman (github: galuhputraa)
- M2142089 Nabiilah Nuur Ainii (github: nabilahnran)

For the capstone project, we build a simple app for _healthcare_ field problem, which is called
***Touchless Hospital Integrated Queueing System***
We hope this application can help people while queueing in hospital, especially in this COVID-19 pandemic situation where everybody should adhere to health protocols, one of them being to avoid and minimize physical contact with public objects and other people.
Besides that, patients don't have to bring any document because the data of the patients has been stored in the hospital cloud database, so patient will just use their own QR code to run this app so that this app can get the patient data much more quickly and easily.

## Roles
Machine learning: number hand gesture image classification to choose poly that patient want to come in, using CNN
###### Python 3.2
###### Model created in Google Colab (file ipnyb)

Android Development: Generating ML model and whole operation in app, using Android Studio
###### Android Studio version:
###### Android phone used to open app version 10
###### Layout: Tab xxxxx

Cloud Computing: Create database and storing them on Google Cloud Platform and store them using Firebase so that the Android application can get the data, deploying the machine learning on AI Platform 
###### Firebase
###### Google Cloud Platform

## Application Workflow
this section with image

1. Patient come to tab that have been provided by hospital
2. Patient scan QR code that they have to app proccess their data, and managing related data in database
3. Patient choosing poly by make a number hand gesture 0-6 (in this example app the hospital have 6 poly), the number depend on what poly they choose. the option and example hand gesture displayed on the screen too. patient's hand gesture will be captured when timer reach 0 (count down from 10)
4. Result (patient's name, choosen poly, number of queue they have, and current number of queue in that poly) appear.
5. After patient entered medical examination room and have been checked by doctor, the doctor insert the medical examination result to the app (login as doctor) and the data integrated in hospital system so patient shouldn't bring any hardcopy documents.
6. Patient's medical records stored in hospital database, can be read, edit by the doctor concerned.

## Links

Database source:
1. Raw dataset
- https://lttm.dei.unipd.it/downloads/gesture 
- https://www.kaggle.com/muhammadkhalid/sign-language-for-numbers
- https://www.kaggle.com/ahmedkhanak1995/sign-language-gesture-images-dataset
- https://drive.google.com/drive/folders/17Pg2_ZfR9A5AMQFEnjYwDSaD6T5jUyGS?usp=sharing (made by team)
2. Cropped Image (from raw dataset)
- https://drive.google.com/drive/folders/1IyF_sD7Zt2C4JU0zBvFppHpnf9_I9aZh?usp=sharing 

