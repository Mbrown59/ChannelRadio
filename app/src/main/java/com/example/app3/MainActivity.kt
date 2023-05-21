package com.example.app3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity()
{
  companion object
  {
    private var instance : MainActivity? = null
    private var webView: WebView? = null

    public fun getInstance() : MainActivity
    {
      return instance!!
    }
  }
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    instance = this




    val navController = Navigation.findNavController(this, R.id.fragment)
    var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    bottomNavigationView.setupWithNavController(navController)

  }

  override fun onBackPressed()
  {

    //if (webView!!.canGoBack())

    //webView?.goBack()
    webView = findViewById<WebView>(R.id.webView)
    webView?.setVisibility(View.INVISIBLE)
    println("back")


  }
}