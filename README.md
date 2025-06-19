Overview:Using Kotlin in Android Studio, create a native Android app that aids users in creating and rating music in a playlist.
The application will need to store the song name, artist, rating and commenta, and calculate the average of these ratings at the end of the playlist. Four songs must be entered. Use GitHub and GitHub Actions.
Features:
-Four songs along with artist, comments and ratings 
-Average rating of the four songs 
-Exit button on both first and last page 
-Save button to save the rating
-Average display on the last page 
- Back to main menu button
-Clean, commented Kotlin code
-GitHub Actions setup for CI

Project Structure:

MainActivity.kt

Displays the Add to playlist, Go to playlist and exit
Both addd to playlist and go to playlist Navigates to PlayList.kt
PlayList.kt

Displays song title, artist name, a rating and comments
Tracks songs and handles the average rating progression
Navigates to average.kt after all questions
average.kt

Shows the final score and feedback
Buttons to Exit

Installation:

Prerequisites:

Android Studio (2020.3.1 or later)
Kotlin plugin installed
Android Emulator or device running API 23+
Steps
Clone the repository:
https://github.com/SonavNaidoo16/musicPlaylistManagerApp
GitHub Actions: name: Android CI

on: push: branches: [ main ] pull_request: branches: [ main ]

jobs: build:

runs-on: ubuntu-latest

steps:
- name: Checkout code
  uses: actions/checkout@v3

- name: Set up JDK 11
  uses: actions/setup-java@v3
  with:
    distribution: 'temurin'
    java-version: 11

- name: Build with Gradle
  run: ./gradlew build
Technologies Used: -Kotlin -Android SDK -Android Studio -Git & GitHub -GitHub Actions (CI)

Home Screen:
![image](https://github.com/user-attachments/assets/dbac9278-86b1-4292-8c78-637c243bbf39)
the buttons allow you to travel through pages or exit 
![image](https://github.com/user-attachments/assets/c9456999-5795-4ef2-bcc8-c8449c35e097)
this code allows for the change of pages buy a click of abutton
![image](https://github.com/user-attachments/assets/1ce2b6c2-a0c6-4a81-8fd9-7de427576cf0)
this code allows for the button to terminate the program 
Music Playlist Page: 
![image](https://github.com/user-attachments/assets/54a9a487-1a92-4a00-86d0-1f79470894fd)
![image](https://github.com/user-attachments/assets/bf848bd5-e277-4dbb-b0b0-edaae0104505)
![image](https://github.com/user-attachments/assets/fe7a20d7-2399-47c5-acaf-a72c284c3240)
![image](https://github.com/user-attachments/assets/f21fbf04-ea90-4f86-9bdc-ed78caad8ce0)
![image](https://github.com/user-attachments/assets/3d47925e-c116-4cc7-8f68-d722ff1fa385)
The PlayList activity serves as a screen where users can:•Input a song's title, artist, a rating (1-5 stars), and a comment.•Save up to 4 songs to a temporary playlist.•View the list of saved songs with their details.•Calculate and display the average rating of all songs in the playlist.•Navigate back to a MainActivity.•Navigate to another activity (presumably named average).Potential Issues/Observations:•Redundant btnShowList and btnSave Variable: The variable btnShowList is initialized twice (once correctly, and once with btnSave = findViewById<Button>(R.id.btnShowList) which is likely a copy-paste error and should probably be btnSave = findViewById<Button>(R.id.btnSave). However, since btnSave is then correctly assigned later, this specific incorrect assignment might not have a direct functional impact unless btnSave was used before its correct assignment.•Overlapping btnSave Listeners: There are two setOnClickListener blocks for btnSave. The second one will effectively replace the first one. The first listener for btnSave would never actually be executed because it's immediately overwritten.•average::class.java: The btnNextPage navigates to average::class.java. This implies there's another Activity named average. Make sure this activity exists and is declared in your AndroidManifest.xml.•Data Persistence: As mentioned, the playlist data is only stored in memory. If the user closes the app, the playlist will be lost.•UI Layout (activity_play_list.xml): The functionality heavily depends on the corresponding XML layout file defining all the R.id.* views.
Concluding Page:
![image](https://github.com/user-attachments/assets/c8c6960c-7ab6-49b4-ad38-3c5732f7f080)
Displays the playlist along with the rating 
![image](https://github.com/user-attachments/assets/0b02676b-3388-485f-8b71-260b10e97f5a)
this code allows for the average from the previous page to be transfered over and displayed along with a exit button to terimate the program 
