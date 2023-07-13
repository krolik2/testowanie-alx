import sys

sys.path.append("")
import pytest

from src.calculator import *


def test_calculate_sum():
    assert calculate_sum(2, 3) == 5
    assert calculate_sum(-1, 1) == 0
    assert calculate_sum(0, 0) == 0
    assert calculate_sum(5, -5) == 0
    assert calculate_sum(-5, -5) == -10
    assert calculate_sum(0.1, 0.2) == 0.3 
    assert calculate_sum(9223372036854775807, 9223372036854775807) == 9,223372036854776e18

def test_calculate_sum_with_strings():
    assert calculate_sum("Hello, ", "world!") == "Hello, world!"
    assert calculate_sum("2", "2") == "22"


def test_calculate_sum_with_lists():
    assert calculate_sum([1, 2, 3], [4, 5, 6]) == [1, 2, 3, 4, 5, 6]
    assert calculate_sum(["a"], ["b"]) == ["a", "b"]


def test_calculate_difference():
    assert calculate_difference(1, 1) == 0
    assert calculate_difference(0, 0) == 0
    assert calculate_difference(-1, 1) == -2
    assert calculate_difference(2, -2) == 4
    assert calculate_difference(0.3, 0.2) == 0.1


def test_calculate_multiply():
    assert calculate_product(2, 2) == 4
    assert calculate_product(0, 0) == 0
    assert calculate_product(-1, 0) == 0
    assert calculate_product(-2, -2) == 4
    assert calculate_product(2, -2) == -4
    assert calculate_product(0.2, 0.1) == 0.02
    assert calculate_product(9223372036854775807, 9223372036854775807) == 85070591730234615847396907784232501249


def test_calculate_multiply_with_string():
    assert calculate_product(2, "abc") == "abcabc"


def test_calculate_multiply_with_list():
    assert calculate_product(2, [1, 2, 3]) == [1, 2, 3, 1, 2, 3]
    assert calculate_product(2, ["a"]) == ["a", "a"]


def test_calculate_division():
    assert calculate_dividend(1, 1) == 1
    assert calculate_dividend(1, 2) == 0.5
    assert calculate_dividend(0, 1) == 0
    assert calculate_dividend(0.2, 2) == 0.1
    with pytest.raises(ZeroDivisionError):
        calculate_dividend(1, 0)
    
