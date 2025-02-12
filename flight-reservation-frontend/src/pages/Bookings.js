import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Table, Button, Form, Container, Row, Col, Card } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Bookings() {
  const [bookings, setBookings] = useState([]);
  const [flights, setFlights] = useState([]);
  const [users, setUsers] = useState([]);
  const [newBooking, setNewBooking] = useState({ seatClass: '', seatCount: 1, amount: '', flightId: '', userId: '' });
  const navigate = useNavigate();

  useEffect(() => {
    fetchBookings();
    fetchFlights();
    fetchUsers();
  }, []);

  const fetchBookings = () => {
    axios.get('http://localhost:8081/api/bookings/getAll')
      .then(response => setBookings(response.data))
      .catch(error => console.error('Error fetching bookings:', error));
  };

  const fetchFlights = () => {
    axios.get('http://localhost:8081/api/flights/getAllFlights')
      .then(response => setFlights(response.data))
      .catch(error => console.error('Error fetching flights:', error));
  };

  const fetchUsers = () => {
    axios.get('http://localhost:8081/api/users/getAllUsers')
      .then(response => setUsers(response.data))
      .catch(error => console.error('Error fetching users:', error));
  };

  const calculateAmount = (flightId, seatClass, seatCount) => {
    const flight = flights.find(f => f.flightId === parseInt(flightId));
    if (!flight) return '';
    let basePrice = flight.price;
    let seatMultiplier = seatClass === 'Business' ? 1.5 : 1;
    return (basePrice * seatMultiplier * seatCount).toFixed(2);
  };

  const handleCreateBooking = (e) => {
    e.preventDefault();
    const flight = flights.find(f => f.flightId === parseInt(newBooking.flightId));
    if (flight) {
      const bookingDate = flight.deptTime;
      const amount = calculateAmount(newBooking.flightId, newBooking.seatClass, newBooking.seatCount);
      const updatedBooking = { ...newBooking, bookingDate, amount };
      axios.post('http://localhost:8081/api/bookings/create', updatedBooking)
        .then(() => {
          fetchBookings();
          setNewBooking({ seatClass: '', seatCount: 1, amount: '', flightId: '', userId: '' });
        })
        .catch(error => console.error('Error creating booking:', error));
    }
  };

  const handleDeleteBooking = (id) => {
    axios.delete(`http://localhost:8081/api/bookings/cancelByEmail?email=${id}`)
      .then(() => fetchBookings())
      .catch(error => console.error('Error deleting booking:', error));
  };

  return (
    <Container>
      <h2 className="text-center my-4">Booking Management</h2>
      <Card className="p-4 shadow">
        <Form onSubmit={handleCreateBooking} className="mb-4">
          <Row>
            <Col>
              <Form.Group>
                <Form.Label>Flight</Form.Label>
                <Form.Control as='select' value={newBooking.flightId} onChange={(e) => setNewBooking({ ...newBooking, flightId: e.target.value, amount: calculateAmount(e.target.value, newBooking.seatClass, newBooking.seatCount) })} required>
                  <option value=''>Select Flight</option>
                  {flights.map(flight => (
                    <option key={flight.flightId} value={flight.flightId}>{flight.airlineName} ({flight.deptAirport} → {flight.arrivalAirport})</option>
                  ))}
                </Form.Control>
              </Form.Group>
            </Col>
            <Col>
              <Form.Group>
                <Form.Label>User</Form.Label>
                <Form.Control as='select' value={newBooking.userId} onChange={(e) => setNewBooking({ ...newBooking, userId: e.target.value })} required>
                  <option value=''>Select User</option>
                  {users.map(user => (
                    <option key={user.userId} value={user.userId}>{user.name} ({user.email})</option>
                  ))}
                </Form.Control>
              </Form.Group>
            </Col>
            <Col>
              <Form.Group>
                <Form.Label>Seat Class</Form.Label>
                <Form.Control as='select' value={newBooking.seatClass} onChange={(e) => setNewBooking({ ...newBooking, seatClass: e.target.value, amount: calculateAmount(newBooking.flightId, e.target.value, newBooking.seatCount) })} required>
                  <option value=''>Select Seat Class</option>
                  <option value='ECONOMY'>Economy</option>
                  <option value='BUSINESS'>Business</option>
                  <option value='FIRST_CLASS'>First_Class</option>
                </Form.Control>
              </Form.Group>
            </Col>
            <Col>
              <Form.Group>
                <Form.Label>Seats</Form.Label>
                <Form.Control type='number' min='1' value={newBooking.seatCount} onChange={(e) => setNewBooking({ ...newBooking, seatCount: e.target.value, amount: calculateAmount(newBooking.flightId, newBooking.seatClass, e.target.value) })} required />
              </Form.Group>
            </Col>
            <Col>
              <Form.Group>
                <Form.Label>Amount</Form.Label>
                <Form.Control type='number' value={newBooking.amount} readOnly />
              </Form.Group>
            </Col>
          </Row>
          <Button type="submit" className="mt-3 w-100 btn-primary">Add Booking</Button>
        </Form>
      </Card>
      <Table striped bordered hover className="mt-4 shadow">
        <thead>
          <tr>
            <th>ID</th>
            <th>Flight</th>
            <th>User</th>
            <th>Booking Date</th>
            <th>Seat Class</th>
            <th>Seats</th>
            <th>Amount</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {bookings.map(booking => (
            <tr key={booking.bookingId}>
              <td>{booking.bookingId}</td>
              <td>{booking.flightId}</td>
              <td>{booking.userId}</td>
              <td>{booking.bookingDate}</td>
              <td>{booking.seatClass}</td>
              <td>{booking.seatCount}</td>
              <td>${booking.amount}</td>
              <td>
                <Button variant="danger" onClick={() => handleDeleteBooking(booking.email)}>Cancel</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
}

export default Bookings;
