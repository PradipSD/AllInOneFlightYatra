// src/pages/Users.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Users() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/api/users')
      .then(response => setUsers(response.data))
      .catch(error => console.error('Error fetching users:', error));
  }, []);

  return (
    <div>
      <h2>Users</h2>
      <ul>
        {users.map(user => (
          <li key={user.userId}>{user.fname} {user.lname} - {user.email} - {user.phoneNo}</li>
        ))}
      </ul>
    </div>
  );
}

export default Users;