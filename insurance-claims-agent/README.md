# Autonomous Insurance Claims Processing Agent

## Overview
This project implements a lightweight Java-based agent that processes
FNOL (First Notice of Loss) documents and automatically determines
the appropriate claims workflow.

The solution parses insurance FNOL PDFs (ACORD Automobile Loss Notice),
extracts key claim fields, identifies missing information, and routes
the claim according to predefined business rules.

---

## Features
- Extracts structured claim data from FNOL PDF documents
- Detects missing mandatory fields
- Applies rule-based claim routing logic
- Produces a clean JSON output with reasoning

---

## Extracted Fields
- Policy Number
- Description of Loss
- Estimated Damage Amount
- Claim Type

---

## Routing Rules
- Estimated damage < 25,000 → Fast-track
- Missing mandatory fields → Manual Review
- Keywords such as "fraud", "staged", "inconsistent" → Investigation Flag
- Injury-related claims → Specialist Queue

---

## Tech Stack
- Java
- Apache PDFBox (PDF parsing)
- Jackson (JSON serialization)
- Maven

---

## Project Structure
