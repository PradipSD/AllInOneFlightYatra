import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Review = () => {
 
  const [reviews, setReviews] = useState([]);
  const [rating, setRating] = useState(1);
  const [comment, setComment] = useState('');
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const response = await axios.get('http://localhost:8081/api/reviews/getAllReviews');
        console.log(response.data);  
        setReviews(response.data);
        setLoading(false);
      } catch (error) {
        console.error('Error fetching reviews:', error);
        setLoading(false);
      }
    };
    fetchReviews();
  }, []);
  

  const handleSubmit = async (e) => {
    e.preventDefault();
    const reviewData = {
      rating,
      review: comment,
      flightId: 101,  
    };

    try {

      await axios.post('http://localhost:8081/api/reviews/addReview', reviewData);
      
      setComment('');
      setRating(1);

  
      const response = await axios.get('http://localhost:8081/api/reviews/getAllReviews');
      setReviews(response.data);
    } catch (error) {
      console.error('Error submitting review:', error);
    }
  };

  return (
    <div className="container">
      <h3 className="my-4">Add a Review</h3>


      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Rating:</label>
          <select
            className="form-control"
            value={rating}
            onChange={(e) => setRating(Number(e.target.value))}
          >
            <option value={1}>1</option>
            <option value={2}>2</option>
            <option value={3}>3</option>
            <option value={4}>4</option>
            <option value={5}>5</option>
          </select>
        </div>
        <div className="form-group mt-3">
          <label>Comment:</label>
          <textarea
            className="form-control"
            rows="4"
            value={comment}
            onChange={(e) => setComment(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary mt-3">Submit Review</button>
      </form>

      <h3 className="my-4">Reviews</h3>


      {loading ? (
        <p>Loading reviews...</p>
      ) : (
        <div className="row">
          {reviews.length === 0 ? (
            <p>No reviews yet.</p>
          ) : (
            reviews.map((review) => (
              <div key={review.reviewId} className="col-md-4 mb-3">
                <div className="card shadow-sm">
                  <div className="card-body">
                    <h5 className="card-title">
                      {review.userFname} ({review.rating} stars)
                    </h5>
                    <p className="card-text">{review.review}</p>
                    <p className="card-text">
                      <small className="text-muted">
                        Reviewed on: {new Date(review.reviewDate).toLocaleDateString()}
                      </small>
                    </p>
                  </div>
                </div>
              </div>
            ))
          )}
        </div>
      )}
    </div>
  );
};

export default Review;
