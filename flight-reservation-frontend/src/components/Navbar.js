// src/components/Navbar.js
import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Navbar() {
  return (
    <nav className='navbar navbar-expand-lg navbar-dark bg-primary'>
      <div className='container'>
        <Link className='navbar-brand' to='/'>Flight Booking System</Link>
        <div className='collapse navbar-collapse'>
          <ul className='navbar-nav me-auto'>
            <li className='nav-item'><Link className='nav-link' to='/airlines'>Airlines</Link></li>
            <li className='nav-item'><Link className='nav-link' to='/flights'>Flights</Link></li>
            <li className='nav-item'><Link className='nav-link' to='/bookings'>Bookings</Link></li>
            <li className='nav-item'><Link className='nav-link' to='/users'>Users</Link></li>
            <li className='nav-item'><Link className='nav-link' to='/reviews'>Reviews</Link></li>
            <li className='nav-item'><Link className='nav-link' to='/payments'>Payments</Link></li>
            <li className='nav-item'><Link className='nav-link' to='/nearest-airports'>Nearest Airports</Link></li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;