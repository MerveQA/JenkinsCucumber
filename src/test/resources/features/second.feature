@c2
Feature: 2.feature

Scenario Outline: Display of main menu headings
When Click All menu button
Then The main menu heading "<heading>" should be displayed
Examples:
| heading                   |
| Digital Content & Devices |
| Shop by Department        |
| Programs & Features       |
| Help & Settings           |


Scenario Outline:  Verify the subcategories under 'Digital Content & Devices'
When Click All menu button
Then Digital Content & Devices "<subcategory>" should be displayed
Examples:
| subcategory              |
| Prime Video              |
| Amazon Music             |
| Kindle E-readers & Books |
| Amazon Appstore          |