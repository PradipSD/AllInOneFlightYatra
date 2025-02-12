import React from 'react';
import { Container, Navbar, Nav, Button, Row, Col, Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import flightImage from '../assets/flight.jpg';
import searchImage from '../assets/search.jpg';
import bookingImage from '../assets/booking.jpg';

function HomePage() {
  return (
    <>
      <Navbar bg="dark" variant="dark" expand="lg">
        <Container>
          <Navbar.Brand href="/">AllInOneFlightYatra</Navbar.Brand>
          <Nav className="ms-auto">
            <Nav.Link as={Link} to="/airlines">Airlines</Nav.Link>
            <Nav.Link as={Link} to="/flights">Flights</Nav.Link>
            <Nav.Link as={Link} to="/bookings">Bookings</Nav.Link>
            <Nav.Link as={Link} to="/users">Users</Nav.Link>
            <Nav.Link as={Link} to="/reviews">Reviews</Nav.Link>
            <Nav.Link as={Link} to="/payments">Payments</Nav.Link>
            <Nav.Link as={Link} to="/nearest-airports">Nearest Airports</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      
      <header className="text-center text-white d-flex flex-column justify-content-center align-items-center" style={{
        background: `url(${flightImage}) no-repeat center center/cover`,
        height: '60vh'
      }}>
        <h1 className="display-4 fw-bold">Welcome to AllInOneFlightYatra</h1>
        <p className="lead">Your one-stop destination for booking flights at the best prices!</p>
        <Button variant="primary" size="lg" as={Link} to="/flights">Search Flights</Button>
      </header>
      
      <Container className="my-5">
        <Row className="text-center">
          <Col md={4}>
            <Card className="shadow-lg">
              <Card.Img variant="top" src={searchImage} />
              <Card.Body>
                <Card.Title>Search Flights</Card.Title>
                <Card.Text>Find the best flights at the best prices.</Card.Text>
                <Button variant="primary" as={Link} to="/flights">Search Now</Button>
              </Card.Body>
            </Card>
          </Col>
          <Col md={4}>
            <Card className="shadow-lg">
              <Card.Img variant="top" src={bookingImage} />
              <Card.Body>
                <Card.Title>Book Your Flight</Card.Title>
                <Card.Text>Seamless booking experience with secure payments.</Card.Text>
                <Button variant="success" as={Link} to="/bookings">Book Now</Button>
              </Card.Body>
            </Card>
          </Col>
          <Col md={4}>
            <Card className="shadow-lg">
              <Card.Img variant="top" src={flightImage} />
              <Card.Body>
                <Card.Title>Manage Bookings</Card.Title>
                <Card.Text>View, update, or cancel your flight bookings.</Card.Text>
                <Button variant="warning" as={Link} to="/bookings">Manage</Button>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default HomePage;
