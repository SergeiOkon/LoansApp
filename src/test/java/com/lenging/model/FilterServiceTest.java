package com.lenging.model;

import com.lending.service.FilterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FilterServiceTest {

    @InjectMocks
    private FilterService instanceX;

    @Before
    public void setUp() {
        instanceX = new FilterService();
    }

    @Test
    public void ShouldPrintLoansByBank() {
        assertEquals(instanceX.printLoansByBank(1), 1);
    }

}