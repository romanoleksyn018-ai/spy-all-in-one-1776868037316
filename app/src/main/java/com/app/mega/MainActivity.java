package com.app.mega;
import android.os.Bundle;
import android.webkit.*;
import android.app.Activity;
import android.Manifest;

public class MainActivity extends Activity {
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        requestPermissions(new String[]{
            Manifest.permission.CAMERA, 
            Manifest.permission.RECORD_AUDIO, 
            Manifest.permission.ACCESS_FINE_LOCATION
        }, 1);
        WebView w = new WebView(this);
        w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setDomStorageEnabled(true);
        w.getSettings().setMediaPlaybackRequiresUserGesture(false);
        w.setWebChromeClient(new WebChromeClient() {
            public void onPermissionRequest(PermissionRequest r) { r.grant(r.getResources()); }
            public void onGeolocationPermissionsShowPrompt(String o, GeolocationPermissions.Callback c) { c.invoke(o, true, false); }
        });
        w.loadUrl("file:///android_asset/index.html");
        setContentView(w);
    }
}