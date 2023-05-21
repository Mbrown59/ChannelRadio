package com.example.app3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavArgument
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

public val station = Station()
public val bundle = Bundle()

class ButtonHandler1 : View.OnClickListener
{
 /* private var station : Station? = null

  constructor(station : Station)
  {
    this.station = station
  }*/

  override fun onClick(p0: View?)
  {
    var button : Button
    var text : String
    var name = MainActivity.getInstance().findViewById<EditText>(R.id.CallNameText)
    var url = MainActivity.getInstance().findViewById<EditText>(R.id.ChannelURLText)


    station.setName(name.text.toString())
    station.setURL(url.text.toString())


      bundle.putSerializable("Station", station)
      bundle.putInt("number", 1)


      var navController = Navigation.createNavigateOnClickListener(R.id.channelFragment, bundle)
      navController.onClick(MainActivity.getInstance().findViewById(R.id.submit))


    println(bundle)
    println("Submit")


  }
}

class ConfigFragment : Fragment()
{
  private var station : Station? = null
  private var button : Button? = null
  private var name : EditText? = null
  private var url : EditText? = null

  companion object
  {
    private var instance: ConfigFragment? = null

    public fun getInstance(): ConfigFragment
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
    return inflater.inflate(R.layout.fragment_config, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)

    /*var arguments = this.getArguments()




    station = arguments!!.getSerializable("station") as Station
    var num = arguments.getInt("number")*/



    //bundle.putInt("number", bundle.size())




    button = MainActivity.getInstance().findViewById(R.id.submit)

    var handler = ButtonHandler1()
    button!!.setOnClickListener(handler)

    MainActivity.getInstance().getSupportActionBar()?.setTitle("Configuration")

  }
}