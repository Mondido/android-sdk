Android SDK for Mondido Payments
=======

Version 1.0


The Android SDK provides developers with a easy-to-use library to make payments in their Android application. 
Open the included demo application and see how it works.

Required Android version is >= v11.

The sample code is a IntelliJ project, but can also be imported to other IDE


IMPORTANT:
---
Mondido is a certified payment provider compliant to Payment Card Industry Data Security Standard (PCI DSS) to provide a secure transaction for merchants and their customers.
PCI compliance for merchants is required for any business accepting cardholder data.

We strongly recommend NOT sending card numbers unencrypted to and from your server.
Let Mondido capture this sensitive information using one of our hosted window or .js solutions to avoid PCI compliance issues.
https://www.mondido.com/documentation/hosted
https://www.mondido.com/documentation/mondidojs

CONFIGURATION:
---
First sign up and create your merchant account at: https://www.mondido.com/registrera

#### Settings

##### Api BaseUrl

https://api.mondido.com/v1

##### Api Username

The merchant id found at: https://www.mondido.com/en/settings#api after you have logged in and created a merchant account

##### Api Password

The merchant password that you have set at: https://www.mondido.com/en/settings#api after you have logged in and created a merchant account

##### Api Secret

The merchant secret that you can find at: https://www.mondido.com/en/settings#api after you have logged in and created a merchant account

##### RSAKey

The merchant RSA public key that you can find at: https://www.mondido.com/en/settings#api after you have logged in and created a merchant account

===========

# Mondido Payments Documentation

Our focus is to make it as smooth as possible for you to implement Mondido and start accepting payments, regardless of whether you are implementing from scratch or already have an existing payment service in place.

Read more
* https://doc.mondido.com/

## Supported Card Types
Default card types that you will have access to are VISA and Mastercard, but the other such as AMEX, JCB and Diners are on separate contracts. Contact support for more information about card types.

* https://doc.mondido.com/api#cardtypes

## Test Cards
To create test transactions you need to send in a test card number, and also a CVV code that can simulate different responses

* https://doc.mondido.com/api#testcards

## Error messages
We aim to send as many insightful and helpful error messages to you as possible, both in numeric, data and human readable.

* https://doc.mondido.com/api#errors

# Help

* FAQ (Swedish) - http://help.mondido.com/

# PCI DSS

Mondido is a certified payment provider compliant to Level 1 Payment Card Industry Data Security Standard (PCI DSS) version 3.1 to provide a secure transaction for merchants and their customers. PCI compliance for merchants is required for any business accepting cardholder data. Let Mondido capture this sensitive information using one of our Hosted Window or mondido.js solutions to avoid PCI compliance issues.

* Payment Card Industry Data Security Standard (PCI DSS) - https://www.pcicomplianceguide.org/pci-faqs-2/#5
* Payment security educational resources - https://www.pcisecuritystandards.org/pci_security/educational_resources
* Hosted Window - https://doc.mondido.com/hosted

# 3D-Secure

Mondido understands the need to incorporate best business practices in security. That's why we've made it easy for merchants to implement 3D Secure or “3 Domain Secure” as the industry standard identity check solution to minimize chargebacks from fraudulent credit cards, all included in our simple pricing. 3D-Secure refers to second authentication factor products such as Verified by Visa, MastercardⓇSecureCode™, American Express SafekeyⓇ, and JCB J/Secure™.

NOTE: While you can create your own payment experience, We strongly recommend using our Hosted Window or Mondido.js solution to save time in implementing 3D-Secure and client side encryption to your checkout procedure.

* Verified by Visa - http://www.visaeurope.com/making-payments/verified-by-visa/
* MastercardⓇSecureCode™ - https://www.mastercard.us/en-us/merchants/safety-security.html
* American Express SafekeyⓇ  - https://www.americanexpress.com/uk/content/safekey-information.html?linknav=uk-securitycentre-home-safekey-learn
* JCB J/Secure™ - http://www.global.jcb/en/

# SSL

Secure Socket Layer is required to securely transfer cardholder data and payment information to Mondido. It is recommended that you purchase a SSL certificate directly through a recognized certification authority such as TrustwaveⓇ, HTTPS.SE or purchase a custom SSL certificate through your current e-commerce solution.

* TrustwaveⓇ - https://ssl.trustwave.com/buy-ssl-certificate?___s=1
* HTTPS.SE - https://https.se/

# Follow us on
* GitHub - https://github.com/Mondido
* Facebook - https://www.facebook.com/mondidopayments
* Twitter https://twitter.com/mondidopay
* LinkedIn  - https://www.linkedin.com/company/mondido
* Instagram - https://www.instagram.com/mondidopay/


Do not hesitate to contact support@mondido.com for any questions!
