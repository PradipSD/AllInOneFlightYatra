import React, { useState, useEffect } from 'react';
import axios from 'axios';

const NearestAirports = () => {
  const [airports, setAirports] = useState([]);
  const [newAirport, setNewAirport] = useState({
    airportName: '',
    city: '',
    country: '',
    longitude: '',
    latitude: ''
  });
  const [loading, setLoading] = useState(true);
  const [editAirport, setEditAirport] = useState(null);


  useEffect(() => {
    const fetchAirports = async () => {
      try {
        const response = await axios.get('http://localhost:8081/api/nearest-airports/getAll');
        setAirports(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching nearest airports:', error);
        setLoading(false);
      }
    };
    fetchAirports();
  }, []);

  const handleAddAirport = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8081/api/nearest-airports/add', newAirport);
      setAirports([...airports, response.data]);  // Add the new airport to the list
      setNewAirport({
        airportName: '',
        city: '',
        country: '',
        longitude: '',
        latitude: ''
      });
    } catch (error) {
      console.error('Error adding new airport:', error);
    }
  };


  const handleUpdateAirport = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put(`http://localhost:8081/api/nearest-airports/update/${editAirport.nearAirportLocId}`, editAirport);
      setAirports(airports.map((airport) => (airport.nearAirportLocId === editAirport.nearAirportLocId ? response.data : airport)));
      setEditAirport(null); // Clear edit form
    } catch (error) {
      console.error('Error updating airport:', error);
    }
  };


  const handleDeleteAirport = async (id) => {
    try {
      await axios.delete(`http://localhost:8081/api/nearest-airports/delete/${id}`);
      setAirports(airports.filter((airport) => airport.nearAirportLocId !== id));  // Remove deleted airport
    } catch (error) {
      console.error('Error deleting airport:', error);
    }
  };

  return (
    <div className="container mt-5">
      <h2>Nearest Airports</h2>
      

      <div className="row">
        {loading ? (
          <p>Loading airports...</p>
        ) : airports.length === 0 ? (
          <p>No nearest airports found.</p>
        ) : (
          airports.map((airport) => (
            <div className="col-md-4 mb-4" key={airport.nearAirportLocId}>
              <div className="card">
                <div className="card-body">
                  <h5 className="card-title">{airport.airportName}</h5>
                  <p className="card-text"><strong>City:</strong> {airport.city}</p>
                  <p className="card-text"><strong>Country:</strong> {airport.country}</p>
                  <p className="card-text"><strong>Location:</strong> ({airport.latitude}, {airport.longitude})</p>
                  <button className="btn btn-info" onClick={() => setEditAirport(airport)}>Edit</button>
                  <button className="btn btn-danger ml-2" onClick={() => handleDeleteAirport(airport.nearAirportLocId)}>Delete</button>
                </div>
              </div>
            </div>
          ))
        )}
      </div>


      <h3 className="mt-5">Add New Airport</h3>
      <form onSubmit={handleAddAirport}>
        <div className="form-group">
          <label>Airport Name</label>
          <input
            type="text"
            className="form-control"
            value={newAirport.airportName}
            onChange={(e) => setNewAirport({ ...newAirport, airportName: e.target.value })}
            required
          />
        </div>
        <div className="form-group">
          <label>City</label>
          <input
            type="text"
            className="form-control"
            value={newAirport.city}
            onChange={(e) => setNewAirport({ ...newAirport, city: e.target.value })}
            required
          />
        </div>
        <div className="form-group">
          <label>Country</label>
          <input
            type="text"
            className="form-control"
            value={newAirport.country}
            onChange={(e) => setNewAirport({ ...newAirport, country: e.target.value })}
            required
          />
        </div>
        <div className="form-group">
          <label>Longitude</label>
          <input
            type="number"
            className="form-control"
            value={newAirport.longitude}
            onChange={(e) => setNewAirport({ ...newAirport, longitude: e.target.value })}
            required
          />
        </div>
        <div className="form-group">
          <label>Latitude</label>
          <input
            type="number"
            className="form-control"
            value={newAirport.latitude}
            onChange={(e) => setNewAirport({ ...newAirport, latitude: e.target.value })}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary mt-3">Add Airport</button>
      </form>


      {editAirport && (
        <div className="mt-5">
          <h3>Edit Airport</h3>
          <form onSubmit={handleUpdateAirport}>
            <div className="form-group">
              <label>Airport Name</label>
              <input
                type="text"
                className="form-control"
                value={editAirport.airportName}
                onChange={(e) => setEditAirport({ ...editAirport, airportName: e.target.value })}
                required
              />
            </div>
            <div className="form-group">
              <label>City</label>
              <input
                type="text"
                className="form-control"
                value={editAirport.city}
                onChange={(e) => setEditAirport({ ...editAirport, city: e.target.value })}
                required
              />
            </div>
            <div className="form-group">
              <label>Country</label>
              <input
                type="text"
                className="form-control"
                value={editAirport.country}
                onChange={(e) => setEditAirport({ ...editAirport, country: e.target.value })}
                required
              />
            </div>
            <div className="form-group">
              <label>Longitude</label>
              <input
                type="number"
                className="form-control"
                value={editAirport.longitude}
                onChange={(e) => setEditAirport({ ...editAirport, longitude: e.target.value })}
                required
              />
            </div>
            <div className="form-group">
              <label>Latitude</label>
              <input
                type="number"
                className="form-control"
                value={editAirport.latitude}
                onChange={(e) => setEditAirport({ ...editAirport, latitude: e.target.value })}
                required
              />
            </div>
            <button type="submit" className="btn btn-warning mt-3">Update Airport</button>
          </form>
        </div>
      )}
    </div>
  );
};

export default NearestAirports;
