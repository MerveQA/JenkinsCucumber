@c3
Feature: 3.feature

Scenario Outline: Verify default visible subcategories under 'Shop by Department'
When Click All menu button
Then Shop by Department "<visibleSubcategory>" should be displayed
Examples:
| visibleSubcategory |
| Electronics        |
| Computers          |
| Smart Home         |
| Arts & Crafts      |


Scenario Outline: Verify the subcategories under 'Programs & Features'
When Click All menu button
Then Programs and Features "<visibleSubcategory>" should be displayed
Examples:
| visibleSubcategory     |
| Gift Cards             |
| Shop By Interest       |
| Amazon Live            |
| International Shopping |