# Danbam-tech Bangkit Capstone Project 2021

Bangkit Academy B21-CAP0061 Capstone Project: Touchless Hospital Integrated Queuing System 

Danbam-tech
- A0050542 Jefry Chiedi (github: klaveriuzent)
- A1221565 Helga Agnizar (github: helgaagnizar)
- C0050483 Rizky Martin (github: RIzky-Martin)
- C0050516 Muhammad Rayyan (github: muhrayyan)
- M0050427 Galuh Putra Warman (github: galuhputraa)
- M2142089 Nabiilah Nuur Ainii (github: nabilahnran)

For the capstone project, we build a simple application for the _healthcare_ field problem called ***Danbamcare***, which is a
***Touchless Hospital Integrated Queueing System***.
We hope this application can help people while queueing in hospital, especially in this COVID-19 pandemic situation where everybody should adhere to health protocols, one of them being to avoid and minimize physical contact with public objects and other people.
Besides that, patients don't have to bring any document because the data of the patients has been stored in the hospital cloud database, so patient will just use their own QR code to run this app so that this app can get the patient data much more quickly and easily.

## Roles
Machine learning: number hand gesture image classification to choose poly that patient want to come in, using CNN
###### Python 3.2
###### Model created in Google Colab (file ipnyb)

Android Development: Generating ML model and whole operation in app, using Android Studio
###### Android Studio v4.2.1
###### Android phone used to open app is recommended android v10
###### Layout: Tab 14 pixel 4 API 30

Cloud Computing: Create a database, store them on Google Cloud Platform, import the database that has been created to Firebase so that the Android application can get the data that has been created, and deploy the machine learning model on AI Platform by using Jupyter Notebook on Google Cloud Platform. Previously we created a relational database using CloudSQL, but this took a lot of credits so we used firebase for our database. We also use Cloud Storage buckets to store datasets that will be used by ML Path
###### Firebase
###### AI Platform (GCP)
###### Cloud Storage (GCP)


## Application Workflow
this section with image

1. Patient come to tab that have been provided by hospital
2. Patient scan QR code that they have for the app proccess their data, and to manage related data in the database
3. Patient choose poly specialization by making a number hand gesture 0-6 (in this example app, the hospital has 6 poly specialization), the number depend on what poly they choose. the options and the hand gesture examples are displayed on the screen too. The patient's hand gesture will be captured when the timer reach 0 (count down from 10)
4. The results which are patient's name, choosen poly, number of queue they have, and the current number of queue in that poly appear.
5. After patient entered the medical examination room and have been checked by the doctor, the doctor insert the medical examination result to the app (login as doctor) and the data is integrated in the hospital system so patient shouldn't bring any hardcopy documents.
6. Patient's medical records are stored in the hospital database and can be read and edited by the concerned doctor.

## Links

Database source:
1. Raw dataset
- https://lttm.dei.unipd.it/downloads/gesture 
- https://www.kaggle.com/muhammadkhalid/sign-language-for-numbers
- https://www.kaggle.com/ahmedkhanak1995/sign-language-gesture-images-dataset
- https://drive.google.com/drive/folders/17Pg2_ZfR9A5AMQFEnjYwDSaD6T5jUyGS?usp=sharing (made by team)
2. Cropped Image (from raw dataset)
- https://drive.google.com/drive/folders/1IyF_sD7Zt2C4JU0zBvFppHpnf9_I9aZh?usp=sharing 

