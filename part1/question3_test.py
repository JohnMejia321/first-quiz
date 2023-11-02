from question3 import alchemy_combine, make_oven


def test_alchemy_combine():

  assert alchemy_combine(
    make_oven(),
    ["lead", "mercury"],
    5000
  ) == "gold"

