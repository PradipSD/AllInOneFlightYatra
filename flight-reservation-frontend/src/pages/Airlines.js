import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Table, Button, Form, Container, Row, Col, Card } from 'react-bootstrap';

function Airlines() {
  const [airlines, setAirlines] = useState([]);
  const [newAirline, setNewAirline] = useState({ airlineName: '', countryOfOrigin: '', contactNumber: '', email: '', website: '' });
  const [searchTerm, setSearchTerm] = useState('');
  const [editAirline, setEditAirline] = useState(null);

  useEffect(() => {
    fetchAirlines();
  }, []);

  const fetchAirlines = () => {
    axios.get('http://localhost:8081/api/airlines/getAllAirlines')
      .then(response => setAirlines(response.data))
      .catch(error => console.error('Error fetching airlines:', error));
  };

  const handleCreateAirline = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8081/api/airlines/addAirline', newAirline)
      .then(() => {
        fetchAirlines();
        setNewAirline({ airlineName: '', countryOfOrigin: '', contactNumber: '', email: '', website: '' });
      })
      .catch(error => console.error('Error creating airline:', error));
  };

  const handleDeleteAirline = (id) => {
    axios.delete(`http://localhost:8081/api/airlines/deleteAirline/${id}`)
      .then(() => fetchAirlines())
      .catch(error => console.error('Error deleting airline:', error));
  };

  const handleSearch = () => {
    axios.get(`http://localhost:8081/api/airlines/getByAirlineName/${searchTerm}`)
      .then(response => setAirlines([response.data]))
      .catch(error => console.error('Error searching airline:', error));
  };

  const handleUpdateAirline = () => {
    if (editAirline) {
      axios.post(`http://localhost:8081/api/airlines/updateAirline/${editAirline.airlineId}`, editAirline)
        .then(() => {
          fetchAirlines();
          setEditAirline(null);
        })
        .catch(error => console.error('Error updating airline:', error));
    }
  };

  return (
    <Container className="mt-4">
      <h2 className="text-center mb-4 text-primary">✈️ Airlines Management</h2>


      <Card className="shadow-sm p-4 mb-4">
        <h4 className="text-center mb-3">Add New Airline</h4>
        <Form onSubmit={handleCreateAirline}>
          <Row>
            <Col md={4}>
              <Form.Group>
                <Form.Label>Airline Name</Form.Label>
                <Form.Control type='text' value={newAirline.airlineName} onChange={(e) => setNewAirline({ ...newAirline, airlineName: e.target.value })} required />
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group>
                <Form.Label>Country of Origin</Form.Label>
                <Form.Control type='text' value={newAirline.countryOfOrigin} onChange={(e) => setNewAirline({ ...newAirline, countryOfOrigin: e.target.value })} required />
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group>
                <Form.Label>Contact Number</Form.Label>
                <Form.Control type='text' value={newAirline.contactNumber} onChange={(e) => setNewAirline({ ...newAirline, contactNumber: e.target.value })} required />
              </Form.Group>
            </Col>
          </Row>
          <Row className="mt-3">
            <Col md={6}>
              <Form.Group>
                <Form.Label>Email</Form.Label>
                <Form.Control type='email' value={newAirline.email} onChange={(e) => setNewAirline({ ...newAirline, email: e.target.value })} required />
              </Form.Group>
            </Col>
            <Col md={6}>
              <Form.Group>
                <Form.Label>Website</Form.Label>
                <Form.Control type='text' value={newAirline.website} onChange={(e) => setNewAirline({ ...newAirline, website: e.target.value })} required />
              </Form.Group>
            </Col>
          </Row>
          <Button type='submit' className='mt-3 w-100 btn-success'>➕ Add Airline</Button>
        </Form>
        
      </Card>
      <Card className="shadow-sm p-3 mb-4">
        <Row>
          <Col md={10}>
            <Form.Control type='text' placeholder="🔍 Search Airline by Name" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} />
          </Col>
          <Col md={2}>
            <Button onClick={handleSearch} className='w-100 btn-primary'>Search</Button>
          </Col>
        </Row>
      </Card>


      <Card className="shadow-sm p-3">
        <h4 className="text-center mb-3">Available Airlines</h4>
        <Table striped bordered hover responsive>
          <thead className="bg-dark text-white">
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Country</th>
              <th>Contact</th>
              <th>Email</th>
              <th>Website</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {airlines.map(airline => (
              <tr key={airline.airlineId}>
                <td>{airline.airlineId}</td>
                <td>{airline.airlineName}</td>
                <td>{airline.countryOfOrigin}</td>
                <td>{airline.contactNumber}</td>
                <td>{airline.email}</td>
                <td><a href={airline.website} target='_blank' rel='noopener noreferrer'>{airline.website}</a></td>
                <td>
                  <Button variant='warning' size="sm" onClick={() => setEditAirline(airline)}>✏️ Edit</Button>{' '}
                  <Button variant='danger' size="sm" onClick={() => handleDeleteAirline(airline.airlineId)}>🗑️ Delete</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Card>

    
      {editAirline && (
        <Card className="shadow-sm p-4 mt-4">
          <h4 className="text-center mb-3">Edit Airline Details</h4>
          <Form>
            {Object.keys(editAirline).map((key) => (
              <Form.Group key={key}>
                <Form.Control type='text' value={editAirline[key]} onChange={(e) => setEditAirline({ ...editAirline, [key]: e.target.value })} />
              </Form.Group>
            ))}
            <Button onClick={handleUpdateAirline} className='mt-2 w-100 btn-info'>💾 Update Airline</Button>
          </Form>
        </Card>
      )}
    </Container>
  );
}

export default Airlines;
