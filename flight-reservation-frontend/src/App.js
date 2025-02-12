// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';
import Airlines from './pages/Airlines';
import Flights from './pages/Flights';
import Bookings from './pages/Bookings';
import Users from './pages/Users';
import Reviews from './pages/Reviews';
import Payments from './pages/Payments';
import NearestAirports from './pages/NearestAirports';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <Router>
      <Navbar />
      <div className='container mt-3'>
        <Routes>
          <Route path='/airlines' element={<Airlines />} />
          <Route path='/flights' element={<Flights />} />
          <Route path='/bookings' element={<Bookings />} />
          <Route path='/users' element={<Users />} />
          <Route path='/reviews' element={<Reviews />} />
          <Route path='/payments' element={<Payments />} />
          <Route path='/nearest-airports' element={<NearestAirports />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;