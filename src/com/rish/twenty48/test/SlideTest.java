package com.rish.twenty48.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.rish.twenty48.model.helper.SlideMoveHelper;

public class SlideTest {

    @Test
    public void testLeftSlide1() {

        int[] arr = { 4, 4, 2, 2 };
        int[] expected = { 8, 4, 0, 0 };

        assertArrayEquals(expected, SlideMoveHelper.slideLeft(arr));
    }

    @Test
    public void testRightSlide2() throws Exception {

        int[] arr = { 4, 4, 2, 2 };
        int[] expected = { 0, 0, 8, 4 };

        assertArrayEquals(expected, SlideMoveHelper.slideRight(arr));
    }

}
