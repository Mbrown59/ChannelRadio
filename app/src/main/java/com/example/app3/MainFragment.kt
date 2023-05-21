package com.example.app3

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentViewHolder
import kotlinx.coroutines.NonCancellable.start

class SlideShow : Thread
{
  private var noStations = 0
  private var duration : Long = 0
  private var imageView : ImageView? = null
  private var fragment : View? = null
  private var files = arrayOf("kabc", "karnam", "karnfm", "kdxe", "klal", "kurb", "wbap", "wfan", "wkim", "wls", "wwtn", "wxyt")

  constructor()
  {
    duration = 5000
    noStations = 12
    imageView = fragment?.findViewById<ImageView?>(R.id.imageView)

  }

  override public fun run()
  {
    while(true)
    {
      var count = 0
      var i = 0

      while(count < noStations)
      {
        println(i)
        println(files[i])
        sleep(duration)
        var handler = Thread(files[i])
        //MainFragment.getInstance().runOnUiThread(handler)
        MainActivity.getInstance().runOnUiThread(handler)
        i++
        count++
      }
    }
  }

  class Thread : Runnable
  {
    private var fn : String = ""
    constructor(fn : String)
    {
      this.fn = fn
    }
    override fun run()
    {
      var imageView = MainActivity.getInstance().findViewById<ImageView>(R.id.imageView)

      var id = MainActivity.getInstance().resources.getIdentifier(fn, "drawable", MainActivity.getInstance().packageName)
      imageView.setImageResource(id)
    }
  }
}

class MainFragment : Fragment()
{

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
      return inflater.inflate(R.layout.fragment_main, container, false)
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?)
  {
    super.onViewCreated(view, savedInstanceState)

    var SlideShow = SlideShow()
    //SlideShow.start()




  }

  companion object
  {
    private var instance : MainFragment? = null
    public fun getInstance() : MainFragment
    {
      return instance!!
    }
  }

  }