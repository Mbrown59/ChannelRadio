package com.example.app3

import java.io.Serializable

class Station : Serializable
{
  private var name : String = ""
  private var url : String = ""

  public fun getName() : String
  {
    return name
  }

  public fun setName(name: String)
  {
    this.name = name
  }

  public fun getURL() : String
  {
    return url
  }

  public fun setURL(url: String)
  {
    this.url = url
  }
}