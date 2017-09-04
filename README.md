# Pre-work - ToDo App

ToDo app is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Vijaya Uppala

Time spent: 4 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/YlLG62V.gif' width="600" />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? 
Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

Android provides a rich application framework that allows building innovative apps easily. It adapts to different devices.
Development tools like Eclipse and Android Studio with emulators make the development cycle more managable. 

Android provides a straightforward XML vocabulary that corresponds to the View classes and subclasses, such as those for widgets and layouts.Declare UI elements in XML. 
Applications can create View and ViewGroup objects (and manipulate their properties) programmatically allowing Instantiating layout elements at runtime. 

In the other platforms I have used, most of the UI work is with XML and CSS mostly. 


**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** An Adapter object acts as a bridge between an AdapterView and the underlying data for that view. The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set. 

    In the context of this app, the ArrayAdapter acts as a bridge between the ArrayList and the ListView. It provides access to the data and also helps in making a View for each item in the ArrayList. 

Purpose of the convertView in the getView: 

    getView() method in Adapter is for generating item's view of a ListView. 

    convertView is for recycling. Let's say you have a listview which can only display 10 items at a time, and currently it is displaying item 1 -> item 10. When you scroll down one item, the item 1 will be out of screen, and item 11 will be displayed. To generate View for item 11, the getView() method will be called, and convertView here is the view of item 1 (which is not neccessary anymore). So instead create a new View object for item 11 (which is costly), why not re-use convertView? => we just check convertView is null or not, if null create new view, else re-use convertView.

## Notes

Compatability issues in running the app on the Genymotion Emulator. 
Issue creating todo.txt file while reading the file for the first time. 
Layout issue- Tool bar overlapping the ListView and hiding the first item in the list. 

## License

    Copyright 2017 Vijaya Uppala

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
