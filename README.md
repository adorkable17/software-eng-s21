# FoodBlocker Pro- Team 13 Software Engineering S21

## Visuals
Demo 1: <https://youtu.be/1XH359Pfe2U>

Demo 2: <https://youtu.be/IxJweFsbFU4>

## Installation
1) Clone/Download the files in the main branch of this project (named LoginApplication after several iterations of subgroup feature integration by Kyle Boyce)

2) Open the files in Android Studio

3) Allow paths to be renamed/refactored

4) Run the app on an emulator

### System Requirements
Android Studio 4.1.3 or newer


## Emulators we tested on
Pixel 3A API 30

Pixel 4 API 27

Pixel 4 API 30

## Testing

Testing was completed via population of this database

## Class Names/Functions
### AppHomePage.java
Main interaction screen of the app, which a successful login will lead to. From here users can choose where in the app they want to navigate to; either Recipes, Restaurants, Social Page, or User Profile.
### Credentials.java
This class receives the user data and saves it into the system for user login.
### currentLocation.java
This class will be activated by a switch and will show the current location of the user.
### MainActivity.java
This class is the login screen for the users.
### MapsActivity.java
This class is the main Restaurants page with Google Maps and default location of Rutgers New Brunswick.
### MapsMain1.java
A placeholder that was used in Integration before Restaurants App Code was added.
### ProfilePageActivity.java
This class is connected to the user interface for the profile page and it allows the user to see their profile page.
### RecipeMain.java
This is the main interaction page that a user is brought to when they want to look at recipes. The user can select if they want to use the Recipe Search Bar or the Random Recipe Generator
### randomRecipe.java
This class is the Random Recipe Generator that displays a spin the wheel that when clicked will bring users to a random recipe from the database.
### recipeDisplay.java
This class holds the default display for a recipe that will take the information as an Intent when the class is called and displays all the information for the specific recipe that was sent to it
### RecipeSearch.java
This class holds the search engine used to search the database for recipes that match the user’s input. It will display the results as clickable buttons that will call the recipeDisplay page and pass the recipe information with the call as an Intent message.
### RegistrationActivity.java
This class is the basis for every class as it initiates the registration of a user.
### resturantDisplay.java
This class holds the display for a restaurant which takes the input as an Intent and displays the corresponding restaurants’ information.
### RestaurantMain.java
This class will direct the user to a restaurant search page.
### RestaurantModal.java
This class defines the data structure for Restaurants which is used to store the information of specific restaurants from the database. This class has a string for restaurant name, phone number, address, latitude, longitude, website and diet tags as well as the picture of the restaurant.
### RestaurantRVAdapter.java
This class allows the implementation of RrecyclerViewer to display a dynamic number of buttons for the results from RestaurantSearch class using the database.  This class also instantiates an on-click listener for the buttons which let the user to see the restaurantDisplay.
### RestaurantSearch.java
This class allows the user to search restaurants from the database.
### SocialMain1.java
A placeholder that was used in Integration before Social App Code was added.
### SocialMain.java
This class will allow the user to share images to post on their Facebook Timeline.
### UserModal.java
This class defines the Recipe Data Structure that is used to store information gathered from the database about a specific recipe. It contains a string for the recipe name, cook time, ingredients, instructions, web source, dietary tags, and a url for the recipe image.
### UserRVAdapter
This class is used to implement a RecyclerViewer to display a dynamic number of buttons for the results produced by the RecipeSearch through the database. It also instantiates an on-click listener for each button that helps bring a user to recipeDisplay.
