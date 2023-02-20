package com.cg.hbm.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.entity.Review;
import com.cg.hbm.exception.InvalidInputDataException;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	private IHotelRepository hotelRepository;
	
	
	@Override
	public List<Review> getAllReviews() {
		
		return reviewRepository.findAll();	
	}

	@Override
	public Review addReview(Review review) {
	
		return reviewRepository.save(review);
	}
	
	@Override
	public List<Review> getReviewByStarRating(int starRating){
		
		
		return reviewRepository.getReviewByStarRating(starRating);
	}

	
	@Override
	public List<Review> getReviewByHotelId(int hotelId) throws InvalidInputDataException {
		
		if(reviewRepository.existsById(hotelId)) {
		return reviewRepository.getReviewByHotelId(hotelId);
		}
		else {
			throw new InvalidInputDataException("No review exists with this key = "+hotelId);
		}
		
	}
	
	@Override
	public List<Review> getReviewByRoomId(int roomId) throws InvalidInputDataException {
		
		if(reviewRepository.existsById(roomId)) {
			return reviewRepository.getReviewByRoomId(roomId);
			}
			else {
				throw new InvalidInputDataException("No review exists with this key = "+roomId);
			}
	}

	@Override
	@Transactional
	
	public Review updateHotelbyReviewId(int rid, int hid) throws InvalidInputDataException 
	{
		// TODO Auto-generated method stub
		
		//1.get student
        Review reviewFromDB = getReviewById(rid);
		
		// 2. get hotel 
		Hotel hotelFromDB = hotelRepository.getReferenceById(hid);
		
		// if hotel & review both are valid and available in DB then 
		if(reviewFromDB != null & hotelFromDB != null)
		{
			List<Review> allReviews = hotelFromDB.getReview();
			
			if(allReviews != null && allReviews.isEmpty() == false)
			{
				allReviews.add(reviewFromDB);
				hotelFromDB.setReview(allReviews);
			}
			else // if course are null  then create ArrayList and add review
			{
				List<Review> newReviewList = new ArrayList<>();
				newReviewList.add(reviewFromDB);
				hotelFromDB.setReview(newReviewList);
			}
			// call repository save method
			hotelRepository.saveAndFlush(hotelFromDB);
			reviewRepository.save(reviewFromDB);
			return reviewFromDB;
		}
		else
		{

			throw new NullPointerException("Either review "+reviewFromDB+"or hotel "+hotelFromDB+" is Null ");
		}
	
	
}

	@Override
	public Review getReviewById(int rid){
		
		if(rid >=1)
		{
			Review savedReview =  reviewRepository.getReferenceById(rid);
			if(savedReview != null) return savedReview;
			else 
			{
				throw new EntityNotFoundException("Invalid Student ID : "+rid);
			}
	}
		// TODO Auto-generated method stub
		return null;
	}
}
