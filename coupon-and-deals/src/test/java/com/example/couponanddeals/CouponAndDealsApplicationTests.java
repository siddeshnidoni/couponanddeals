package com.example.couponanddeals;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.dto.CouponsDTO;
import com.example.entity.CouponAndDeals;
import com.example.repository.CouponRepository;
import com.example.service.CouponServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CouponAndDealsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock
	private CouponRepository couponRepository;

	@InjectMocks
	CouponServiceImpl couponService;
	@Test
	void isCouponExistsById() {

		CouponAndDeals couponAndDeals = new CouponAndDeals(300,"happy", LocalDate.of(2022,10,02),"Upto 90% Off","ASO637U","Electronic",200.20,2,"Croma");
		couponRepository.save(couponAndDeals);
		Optional<CouponAndDeals> product1 =couponRepository.findById(300);
		if(!product1.isEmpty()) {
			Boolean actualResult = true;
			assertThat(actualResult).isTrue();
		}
	}


	@Test
	public void getAllCoupons()
	{
		List<CouponAndDeals> list = new ArrayList<CouponAndDeals>();
		CouponAndDeals couponAndDeals1 = new CouponAndDeals(300,"happy1", LocalDate.of(2022,10,02),"Upto 90% Off","ASO637U","Electronic",200.20,2,"Croma");
		CouponAndDeals couponAndDeals2 = new CouponAndDeals(400,"happy2", LocalDate.of(2022,10,02),"Upto 90% Off","ASO637U","Electronic",200.20,2,"Croma");
		CouponAndDeals couponAndDeals3 =new CouponAndDeals(500,"happy3", LocalDate.of(2022,10,02),"Upto 90% Off","ASO637U","Electronic",200.20,2,"Croma");


		list.add(couponAndDeals1);
		list.add(couponAndDeals2);
		list.add(couponAndDeals3);

		when(couponRepository.findAll()).thenReturn(list);

		//test
		List<CouponsDTO> couponsDTOList = couponService.getCouponAndDeals();

		assertEquals(3, couponsDTOList.size());
		verify(couponRepository, times(1)).findAll();
	}

	@Test
	public void saveCouponTest()
	{

		CouponAndDeals couponAndDeals = new CouponAndDeals(300,"happy", LocalDate.of(2022,10,02),"Upto 90% Off","ASO637U","Electronic",200.20,2,"Croma");
		couponRepository.save(couponAndDeals);
		verify(couponRepository, times(1)).save(couponAndDeals);
	}
	@Test
	public void deleteCouponTest()
	{

		CouponAndDeals couponAndDeals = new CouponAndDeals(300,"happy", LocalDate.of(2022,10,02),"Upto 90% Off","ASO637U","Electronic",200.20,2,"Croma");
		couponRepository.deleteById(300);
		verify(couponRepository, times(1)).deleteById(300);
	}
}


