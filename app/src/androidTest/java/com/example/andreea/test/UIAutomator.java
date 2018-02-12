package com.example.andreea.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by Andreea on 2/12/2018.
 */

public class UIAutomator {
    private static final String BASIC_SAMPLE_PACKAGE
            = "com.example.andreea.test";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;

    @Before
    public void setup() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
    }
    @Ignore
    @Test
    public void OpenNotification () throws RemoteException {
      if ( mDevice.isScreenOn() ) {
          mDevice.pressMenu();
      }
    }

    @Test
    public void OpenSettings () throws UiObjectNotFoundException {
        mDevice.pressHome();
        UiObject settings = mDevice.findObject(new UiSelector()
        .text("Settings")
        .className("android.widget.TextView"));
        settings.click();
        UiObject openWifi = mDevice.findObject(new UiSelector()
                .text("Wi-Fi")
                .className("android.widget.TextView"));
        openWifi.click();
        UiObject wifibutton = mDevice.findObject(new UiSelector()
                .resourceId("android:id/switch_widget")
                .className("android.widget.Switch")
                .packageName("com.android.settings")
        );
        wifibutton.click();
        UiObject network = mDevice.findObject(new UiSelector()
                .className("android.widget.LinearLayout")
                .packageName("com.android.settings")
                .description("UPC82FA1E9,Encrypted (WPS available),Full Wi-Fi signal."));
        network.click();
        UiObject password = mDevice.findObject(new UiSelector()
                .text("Password")
                .resourceId("com.android.settings:id/password")
                .className("android.widget.EditText")
                .packageName("com.android.settings"));
        password.setText("y3tAdwd5wdje");
        UiObject connect = mDevice.findObject(new UiSelector()
                .text("CONNECT")
                .resourceId("com.android.settings:id/btn_wifi_connect")
                .className("android.widget.Button")
                .packageName("com.android.settings"));
        connect.click();
        mDevice.pressHome();

    }

    @Test
    public void OpenYoutbe() throws UiObjectNotFoundException{
        mDevice.pressHome();
        UiObject youtube = mDevice.findObject(new UiSelector()
              .text("YouTube")
        );
        youtube.click();
        UiObject search = mDevice.findObject(new UiSelector()
                .className("android.widget.ImageView")
                .packageName("com.google.android.youtube")
                .description("Search")
        );
        search.clickAndWaitForNewWindow();
        UiObject entervideoname = mDevice.findObject(new UiSelector()
                .text("Search YouTube")
            );
        entervideoname.setText("Google");
        UiObject selectvideo = mDevice.findObject(new UiSelector()
                .index(1)
                .resourceId("com.google.android.youtube:id/text")
                .className("android.widget.TextView")
        );
        selectvideo.click();
        UiObject clickvideo = mDevice.findObject(new UiSelector()
                .text("Annoying Orange - Google Yourself Challenge!")
                .resourceId("com.google.android.youtube:id/title")
                .className("android.widget.TextView")
        );
        clickvideo.click();


        UiObject pause = mDevice.findObject(new UiSelector()
                .resourceId("com.google.android.youtube:id/player_control_play_pause_replay_button")
                .className("android.widget.ImageView")
                .packageName("com.google.android.youtube")
                .description("Pause video"));
        pause.click();
        UiObject play = mDevice.findObject(new UiSelector()
                .resourceId("com.google.android.youtube:id/player_control_play_pause_replay_button")
                .className("android.widget.ImageView")
                .packageName("com.google.android.youtube")
                .description("Play video")
        );
        play.click();

            }

    }
