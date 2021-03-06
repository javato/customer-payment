# Customer Payment Matcher

customer-payment is a simple API which verifies if our two Customer and Payment entities are properly matched.

## Dependencies
- spring-boot-starter
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- mysql-connector-java

## Requirements
- JDK 11
- Maven

## Spring profiles
### default

`-Dspring.profiles.active=default`

It expects a MySQL database running at this jdbc:
`jdbc:mysql://localhost:3306/customer-payment`

Generation script of the schema and data inserts can be found in project path `mysql/script_MySQL_forward_engineering.sql`


### H2

`-Dspring.profiles.active=default`

No need of setting up any external database. H2 in memory will be used and data is initialized based on `src/main/resources/data.sql`

## Data
Same data is loaded either MySQL or H2 profile.

### Customer Table
| ID | FIRST_NAME | LAST_NAME | IBAN_ENCRYPTED*                          | HASH_IBAN*                       | ADDRESS                  | CONTRACT_ID |
|----|------------|-----------|------------------------------------------|----------------------------------|--------------------------|-------------|
| 0  | Alice      | Novette   | b59c6b236ece066f145c2a195d68c4ef640de2b9 | 9393117fc22175732ea7042f33d89efb | Rue du Moulin 2 Lausanne | 111         |
| 1  | Bob        | Novet     | 026f86219b64a1fc1d4ef177b4537c47fd27b258 | 094171314505c1458b85388df50457d1 | Rue du Moulin 3 Lausanne | 113         |
| 2  | Céline     | Carou     | 0aadc241c06c54f09429dfecc0934b7f015fabfc | 4d93c7c2a242d413a793df2ba0b6b26d | Rue Etraz 4 Lausanne     | 58          |

### Payment Table
| ID | NAME         | ADDRESS                  | IBAN*            | COMMENT       | CUSTOMER_ID |
|----|--------------|--------------------------|------------------|---------------|-------------|
| 1  | Alice Novett | Rue du Moulin 2 Lausanne | AAAABBBBCCCCDDDD | Alice Novette | 1           |
| 2  | Bob Novet    | Rue du Moulin 2 Lausanne | BBBBCCCCDDDDEEEE | 113           | 2           |
| 3  | Céline Carou | Rue du Moulin 3 Lausanne | CCCCDDDDEEEEFFFF | Useless stuff | 3           |

* AAAABBBBCCCCDDDD --> SHA1: b59c6b236ece066f145c2a195d68c4ef640de2b9 || MD5 Hash: 9393117fc22175732ea7042f33d89efb
* BBBBCCCCDDDDEEEE --> SHA1: 026f86219b64a1fc1d4ef177b4537c47fd27b258 || MD5 Hash: 094171314505c1458b85388df50457d1
* CCCCDDDDEEEEFFFF --> SHA1: 0aadc241c06c54f09429dfecc0934b7f015fabfc || MD5 Hash: 4d93c7c2a242d413a793df2ba0b6b26d

Tool to encrypt and hash IBAN:
https://www.md5hashgenerator.com/

## Installation
### Docker
Instead of download the source code and run it locally, we have the possibility to run it directly using a Docker image.

#### Prerequisites

In order to run this image you will need docker installed.
- [Windows](https://docs.docker.com/desktop/windows/)
- [OS X](https://docs.docker.com/desktop/mac/)
- [Linux](https://docs.docker.com/desktop/linux/)

#### Usage

We can pull it locally from our public repository:

```bash
docker pull dozze/customer-payment:latest
```

And then run it:
#### H2 profile
Simplest way is to directly run it using h2 profile, then we our application will be ready using only this command:
```bash
docker run -e "SPRING_PROFILES_ACTIVE=h2" -p 8080:8080 --name customer-payment -d dozze/customer-payment:latest
```

### Building and running source code
#### Clone
Clone this repository to your local machine `https://github.com/javato/customer-payment.git`.

#### Import
Import as a maven project.

#### Set up MySQL database (only if h2 profile is not enabled)
```bash
docker run --name mysql-jroldan -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.19`
```

#### Run locally
Since it is a Spring Boot Application, we should execute the main method of the `org.jroldan.customerpayment.CustomerPaymentApplication` class.

## REST API
Our server is listening for requests at `http://localhost:8080/`

### perfect-match-api
#### [GET] perfect-match-api
Request Parameters:
- customerId: Mandatory
- paymentId: Mandatory

Url: `http://localhost:8080/perfect-match-api?customerId={{customerId}}&paymentId={{paymentId}}`

Response:
ResponseEntity<Boolean>

Response codes:
- 200: OK
- 500: Internal Server Error

Request example:
`http://localhost:8080/perfect-match-api?customerId=2&paymentId=2`

## License
Released under the Apache License 2.0. See the LICENSE file.