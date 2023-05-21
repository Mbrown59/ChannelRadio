package com.example.app3

import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.view.View.*
import android.webkit.*
import android.widget.LinearLayout
import androidx.navigation.Navigation
import android.widget.Space
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity

private var addedStation : String? = null

class Delegate : WebViewClient()
{
  override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?)
  {
    super.onPageStarted(view, url, favicon)
    println("started")
  }

  override fun onPageFinished(view: WebView, url: String)
  {
    super.onPageFinished(view, url)
    println("finish")
  }

  override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError)
  {
    println(error.description)
  }

  override fun onReceivedHttpError(
    view: WebView, request: WebResourceRequest, errorResponse: WebResourceResponse
  )
  {
    println(errorResponse.data)
  }

  override fun onReceivedSslError(
    view: WebView, handler: SslErrorHandler,
    error: SslError
  )
  {
    println(error.primaryError)
  }
}

fun isNetworkAvailable(context: Context): Boolean
{
  var result = false
  (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    {

      result = isCapableNetwork(this, this.activeNetwork)

    } else
    {
      val networkInfos = this.allNetworks
      for (tempNetworkInfo in networkInfos)
      {
        if (isCapableNetwork(this, tempNetworkInfo))
          result = true
      }
    }
  }
  return result
}

fun isCapableNetwork(cm: ConnectivityManager, network: Network?): Boolean
{
  cm.getNetworkCapabilities(network)?.also {
    if (it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
    {
      return true
    } else if (it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    {
      return true
    }
  }
  return false
}

class ButtonHandler : View.OnClickListener
{
  private var arguments : Bundle? = null
  override fun onClick(p0: View?)
  {
    println("Click Button" + (p0 as Button).getText())
    //var navController = 			Navigation.findNavController(ThirdFragment.getInstance().requireView())
    //Trkansition to 5th Fragment and send null Bundle
    //navController.navigate(R.id.thirdToFifth, null)
  var text = (p0 as Button).getText()

    var webView: WebView? = null
    webView = MainActivity.getInstance().findViewById(R.id.webView)
    var delegate = Delegate();
    webView?.webViewClient = delegate

    if(text == "kabc")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/karnam.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "karnam")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/karnam.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "karnfm")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/karnfm.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "kdxe")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/kdxefm.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "klal")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/klalfm.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "kurb")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/kurbfm.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "wbapam")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/wbapam.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "wfan")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/wfanam.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "wlsam")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/wlsam.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "wwtn")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/wwtnfm.mp3"
      webView?.loadUrl(play)

    }
    else if(text == "wwyt")
    {
      var play = "http://playerservices.streamtheworld.com/api/livestream-redirect/wwytfm.mp3"
      webView?.loadUrl(play)

    }
    else
    {
      var play = addedStation
      webView?.loadUrl(play!!)


    }


    //This will allow the tracing of links
    webView?.getSettings()?.setJavaScriptEnabled(true)
    webView?.getSettings()?.setJavaScriptCanOpenWindowsAutomatically(true)
    webView.setVisibility(View.VISIBLE)
  }
  private fun setArgument(arguments : Bundle)
  {
    this.arguments = arguments
  }

  private fun getArgument() : Bundle
  {
    return arguments!!
  }

}


class ChannelFragment : Fragment()
{


  companion object
  {
    private var instance : ChannelFragment? = null

    public fun getInstance() : ChannelFragment
    {
      return instance!!
    }
  }

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    instance = this



  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View?
  {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_channel, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)
  //var station : Station? = null

    /*var bundle = bundleOf("kabc" to "youtube", "karnam" to "d", "karnfm" to "d", "kdxe" to "s", "klal" to "k", "kurb" to "o", "wbap" to "p",
    "wfan" to "p", "wkim" to "l", "wls" to "d", "wwtn" to "d", "wxyt" to "d")*/



  //var bundle : Bundle? = null

    var arguments = this.getArguments()



    //var b0 = inflate(MainActivity.getInstance(), R.layout.button, null) as Button
    //b0.setText("kabc")
    var i = 0
     var files = arrayListOf("kabc", "karnam", "karnfm", "kdxe", "klal", "kurb", "wbap", "wfan", "wkim", "wls", "wwtn", "wxyt")

      var station1 = arguments?.getSerializable("Station") as Station?
    if (station1 != null)
    {
      files.add(station1.getName())
    }
    if (station1 != null)
    {
      addedStation = station1.getURL()
    }
    if (station1 != null)
    {
      println(station1.getName())
    }




    while(i in 0..files.size - 1)
{
println(files[i])
   //files[files.size + i] = s.getName()
  //println(s.getName())
  var button1 = inflate(MainActivity.getInstance(), R.layout.button, null) as Button
  button1.setText(files[i])
  var handler = ButtonHandler()
  button1.setOnClickListener(handler)
    var linearLayout =
  MainActivity.getInstance().findViewById<LinearLayout>(R.id.linearLayout)
  linearLayout.addView(button1)

  var space = Space(MainActivity.getInstance())
  space.minimumHeight = 15

  linearLayout.addView(space)
  i++
}

    var linearLayout =
      MainActivity.getInstance().findViewById<LinearLayout>(R.id.linearLayout)

    var space = Space(MainActivity.getInstance())
    space.minimumHeight = 100

    linearLayout.addView(space)






   /* if (station != null)
    {
      button1.setText(station.getName())
    }


      button1.setOnClickListener(handler)

    */


    //linearLayout.addView(b0)


    MainActivity.getInstance().getSupportActionBar()?.setTitle("Channels")


  }


}