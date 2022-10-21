import React from "react"
import { Link, } from "react-router-dom"
import './../styling/nav.css'


export default function Navbar(props) {

  return (
    <div className="header">
          <nav >
        <Link className="navbar_link" to = "/">Home</Link>
        <Link className="navbar_link" to = "/policyholders">Policy Holders</Link>
        <Link className="navbar_link" to = "/vehicles">Vehicles</Link>
        <Link className="navbar_link" to = "/claims">Claims</Link>
    </nav>
  </div>

  )
}

