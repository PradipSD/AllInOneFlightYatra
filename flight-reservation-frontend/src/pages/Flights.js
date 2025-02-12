import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Form, Button, Card, Container, Row, Col, Table, Modal } from 'react-bootstrap';

function Flights() {
  const [flights, setFlights] = useState([]);
  const [airlines, setAirlines] = useState([]);
  const [searchParams, setSearchParams] = useState({ deptAirport: '', arrivalAirport: '', deptDate: '' });
  const [newFlight, setNewFlight] = useState({ airlineId: '', airlineName: '', deptAirport: '', arrivalAirport: '', deptTime: '', arrivalTime: '', availableSeats: 1, price: 1, flightStatus: '' });
  const [editFlight, setEditFlight] = useState(null);
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    fetchFlights();
    fetchAirlines();
  }, []);

  const fetchFlights = () => {
    axios.get('http://localhost:8081/api/flights/getAllFlights')
      .then(response => setFlights(response.data))
      .catch(error => console.error('Error fetching flights:', error));
  };

  const fetchAirlines = () => {
    axios.get('http://localhost:8081/api/airlines/getAllAirlines')
      .then(response => setAirlines(response.data))
      .catch(error => console.error('Error fetching airlines:', error));
  };

  const handleCreateFlight = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8081/api/flights/addFlight', newFlight, {
      headers: { 'Content-Type': 'application/json' }
    })
      .then(() => {
        fetchFlights();
        setNewFlight({ airlineId: '', airlineName: '', deptAirport: '', arrivalAirport: '', deptTime: '', arrivalTime: '', availableSeats: 1, price: 1, flightStatus: '' });
      })
      .catch(error => console.error('Error creating flight:', error.response?.data || error.message));
  };

  const handleSearch = () => {
    axios.get(`http://localhost:8081/api/flights/search`, { params: searchParams })
      .then(response => setFlights(response.data))
      .catch(error => console.error('Error searching flights:', error));
  };

  const handleDeleteFlight = (id) => {
    axios.delete(`http://localhost:8081/api/flights/deleteFlight/${id}`)
      .then(() => fetchFlights())
      .catch(error => console.error('Error deleting flight:', error));
  };

  const handleUpdateFlight = () => {
    axios.put(`http://localhost:8081/api/flights/updateFlight/${editFlight.flightId}`, editFlight, {
      headers: { 'Content-Type': 'application/json' }
    })
      .then(() => {
        fetchFlights();
        setEditFlight(null);
        setShowModal(false);
      })
      .catch(error => console.error('Error updating flight:', error.response?.data || error.message));
  };

  return (
    <Container>
      <h2 className='text-center mt-4 mb-4'>Manage Flights</h2>
      <Row>
        <Col md={6}>
          <Card className='p-4 shadow-sm'>
            <h4 className='mb-3'>Search Flights</h4>
            <Form>
              <Form.Group>
                <Form.Label>Departure Airport</Form.Label>
                <Form.Control type='text' placeholder='Enter Departure Airport' value={searchParams.deptAirport} onChange={(e) => setSearchParams({ ...searchParams, deptAirport: e.target.value })} />
              </Form.Group>
              <Form.Group>
                <Form.Label>Arrival Airport</Form.Label>
                <Form.Control type='text' placeholder='Enter Arrival Airport' value={searchParams.arrivalAirport} onChange={(e) => setSearchParams({ ...searchParams, arrivalAirport: e.target.value })} />
              </Form.Group>
              <Form.Group>
                <Form.Label>Departure Date</Form.Label>
                <Form.Control type='date' value={searchParams.deptDate} onChange={(e) => setSearchParams({ ...searchParams, deptDate: e.target.value })} />
              </Form.Group>
              <Button className='mt-2 w-100' onClick={handleSearch}>Search</Button>
            </Form>
          </Card>
        </Col>
      </Row>
      <Row className='mt-4'>
        <Col>
          <Card className='p-4 shadow-sm'>
            <h4 className='mb-3'>Flights List</h4>
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Airline</th>
                  <th>Departure</th>
                  <th>Arrival</th>
                  <th>Dept Time</th>
                  <th>Arrival Time</th>
                  <th>Seats</th>
                  <th>Price</th>
                  <th>Status</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {flights.map(flight => (
                  <tr key={flight.flightId}>
                    <td>{flight.flightId}</td>
                    <td>{flight.airlineName}</td>
                    <td>{flight.deptAirport}</td>
                    <td>{flight.arrivalAirport}</td>
                    <td>{flight.deptTime}</td>
                    <td>{flight.arrivalTime}</td>
                    <td>{flight.availableSeats}</td>
                    <td>${flight.price}</td>
                    <td>{flight.flightStatus}</td>
                    <td>
                      <Button variant='warning' onClick={() => { setEditFlight(flight); setShowModal(true); }}>Edit</Button>{' '}
                      <Button variant='danger' onClick={() => handleDeleteFlight(flight.flightId)}>Delete</Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </Card>
        </Col>
      </Row>
    </Container>
  );
}

export default Flights;