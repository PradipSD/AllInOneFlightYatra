import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Payments() {
  const [payments, setPayments] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/api/payments')
      .then(response => setPayments(response.data))
      .catch(error => console.error('Error fetching payments:', error));
  }, []);

  return (
    <div>
      <h2>Payments</h2>
      <ul>
        {payments.map(payment => (
          <li key={payment.paymentId}>Booking ID: {payment.booking.bookingId} - Amount: ${payment.amount} - Status: {payment.paymentStatus}</li>
        ))}
      </ul>
    </div>
  );
}

export default Payments;