# Changelog

## Release 2.13
Brief Summary
- Fixed a bug to avoid rounding errors, so release versions with closely related version number are matched correctly
- Upgrade repository to Spring Boot 4.1.1
---

## Release 2.12
Brief summary:
 - upgrade the base image of the Dockerfile

---


## Release 2.11
Brief summary of what's in this release:
- n/a

## Release 2.10 (12/11/25)
Brief summary of what's in this release:
- n/a

----

## Release 2.8 (06/30/2025)
Brief summary of what's in this release:
- no changes, increasing version numbers to stay in line with front-end code version


### Breaking changes
n/a


----


## Release 2.7 (4/28/2025)
Brief summary of what's in this release:
- Fixed some tests

### Breaking changes
Breaking changes include any database updates needed, if we need to edit any files on system (like .env or certs, etc). Things that are outside of the code itself that need changed for the system to work.
None

----

## Release 2.6 (12/19/2024)
Brief summary of what's in this release:
- Add code to uniquify the clinical data for filters
- changes to get clinical data from the new table
- change tissueType to enrollmentCategory

### Breaking changes
Breaking changes include any database updates needed, if we need to edit any files on system (like .env or certs, etc). Things that are outside of the code itself that need changed for the system to work.
- This will not work with older versions of the web front-ends because of changes to tables

----

## Release 2.5 (10/3/2024)
Brief summary of what's in this release:
- Java upgrade
  
### Breaking changes
None

### Non-breaking changes
None

----

## Release 2.4 (released 07/08/2024)
Brief summary of what's in this release:
- fixed build action to tag image correctly
- if only new sv data, will still tag as "Recenlty Released"

### Breaking changes

Breaking changes include any database updates needed, if we need to edit any files on system (like .env or certs, etc). Things that are outside of the code itself that need changed for the system to work.


### Non-breaking changes

Just a place to keep track of things that have changed in the code that we may want to pay special attention to when smoke testing, etc.
