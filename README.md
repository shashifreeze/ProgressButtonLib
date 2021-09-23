# ProgressButtonLib
[![](https://jitpack.io/v/shashifreeze/ProgressButtonLib.svg)](https://jitpack.io/#shashifreeze/ProgressButtonLib)

Progress Button for android projects.

<b>About progress button:</b>

There are two buttons this library provides

1> PorgressButton

![ezgif com-gif-maker](https://user-images.githubusercontent.com/30362030/134495610-6326b04e-23b6-4e21-aa88-960736a832ed.gif)


2> ProgressLoadingButton

![ezgif com-gif-maker](https://user-images.githubusercontent.com/30362030/134495090-4e304afc-a9f8-4362-97bc-8c5c8f16bd36.gif)


Add it in your root build.gradle(project level) at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency(Add to app level build.gradle file)

	dependencies {
	        implementation 'com.github.shashifreeze:ProgressButtonLib:Tag'
	}

Attributes for ProgressButton are:

```XML
        <attr name="pb_text_color" format="color|reference" />
        <attr name="pb_start_bg_color" format="color|reference" />
        <attr name="pb_progress_color" format="color|reference" />
        <attr name="pb_text_size" format="dimension|reference" />
        <attr name="pb_before_progress_text" format="string" />
        <attr name="pb_on_progress_text" format="string" />
        <attr name="pb_after_progress_text" format="string" />
        <attr name="pb_text_gravity" format="integer"/>
``` 
Attributes for ProgressLoadingButton are:

```XML
 <attr name="plb_text_color" format="color|reference" />
        <attr name="plb_start_bg_color" format="color|reference" />
        <attr name="plb_progress_color" format="color|reference" />
        <attr name="plb_text_size" format="dimension|reference" />
        <attr name="plb_before_progress_text" format="string" />
        <attr name="plb_after_progress_text" format="string" />
        <attr name="plb_text_gravity" format="integer"/>
``` 

<b>How to use ProgressButton?</b>

Add in yout activity or fragment XML layout file: 

```XML
<com.shashifreeze.progressbutton.ProgressButton
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        android:id="@+id/pb"
        android:gravity="center"
        app:cardBackgroundColor="@color/black"
        app:cardCornerRadius="6dp"
        app:pb_text_color = "@color/white"
        app:pb_text_gravity = "1"
        app:plb_text_size = "6sp"
        app:pb_progress_color = "@color/white"
        app:pb_before_progress_text = "ProgressButton"
        android:layout_height="wrap_content" />
``` 

In your java or kotlin file:

To start showing loading progress bar inside the button use method
```XML
startProgress("Your to show while loading","background color")
``` 
To stop showing loading progress bar inside the button use method 
```XML
stopProgress("Your text to show after loading ends","background color")
``` 

<b>How to use ProgressLoadingButton?</b>

Add in yout activity or fragment XML layout file: 

```XML
 <com.shashifreeze.progressbutton.ProgressLoadingButton
        android:layout_width="match_parent"
        android:layout_margin="10dp"
        android:id="@+id/plb_btn"
        android:gravity="center"
        app:cardBackgroundColor="@color/black"
        app:cardCornerRadius="6dp"
        app:plb_text_color = "@color/white"
        app:plb_text_gravity = "1"
        app:plb_progress_color = "@color/black"
        app:plb_text_size = "6sp"
        app:plb_before_progress_text = "ProgressLoadingButton"
        android:layout_height="wrap_content" />
``` 

In your java or kotlin file:

To start showing loading progress bar inside the button use method
```XML
startProgress("background color")
``` 
To stop showing loading progress bar inside the button use method 
```XML
stopProgress("Your text to show after loading ends","background color")
``` 

See example here
https://github.com/shashifreeze/ProgressButtonLib/blob/master/app/src/main/java/com/shashifreeze/progressbuttonlib/MainActivity.kt
