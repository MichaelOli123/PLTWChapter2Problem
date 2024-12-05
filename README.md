# Modified PLTW Unit 2: Sell My Pet Project

In this project, you will work in teams of 2 to complete a modified version of the [PLTW Unit 2, *Sell My Pet Food* problem](https://pltw.read.inkling.com/a/b/7db822ffb753422ca6c1b9126e7d8100/p/26c4dea4694a4818b0b6b1a44aa2774e). Please refer to the **[Unit 2 Sell My Pet jsoup - Teams Sheet](https://docs.google.com/spreadsheets/d/1Ti-NQO2pySe0ZWMq6LJbzdDS0PYlXLOxN3OTNquRTPg/edit?usp=sharing)** for team assignments.

## Modifications

1. **Choose a Different Product**: Instead of Pet Food, select a different product to focus on.

2. **Create a Custom `socialMediaPosts.txt` File**:
   - Your file must contain at least 50 entries.
   - The file should be structured as a CSV with the following format:
     ```
     "reviewer name", "review", "other fields that you find interesting"
     ```
   - Example (using an Amazon review):
     ```csv
     "Stephen T. Grasela", "This is the best product ever!", "5 stars", "2023-11-20", "Verified"
     ```

   - Identify relevant fields for your product, such as:
     - Reviewer name
     - Review
     - Number of Stars
     - Date of Review
     - Verified Purchase (or not)

3. **Scrape Data Using Jsoup**:
   - Use Jsoup to scrape product review data from a website.
   - Extract desired fields and save them into your `socialMediaPosts.txt` file.
   - Example HTML snippet:
     ```html
     <div class="a-profile-content">
         <span class="a-profile-name">Stephen T. Grasela</span>
     </div>
     ```
   - Ensure your program handles and processes this data into the required CSV format.

   **Note**: Some websites, such as Amazon, include JavaScript to prevent automated scraping. In such cases:
   - Download the page locally and remove JavaScript.
   - Combine multiple pages if reviews are paginated.

## Steps to Complete the Assignment

1. **Form a Team**: Pair up as directed by your teacher.

2. **Review Requirements**: Refer to the original PLTW assignment for detailed solution requirements.

3. **Plan and Create a Milestone Chart**:
   - Break the problem into smaller parts.
   - Define milestones for each part.

4. **Design**: Follow step 9 of the PLTW assignment.

5. **Create and Test**:
   - Implement your solution following steps 10-14.

6. **Evaluate the Solution**:
   - Participate in a gallery walk to showcase your project (steps 15-16).

7. **Document and Present**:
   - Include the following in your presentation:
     - Milestone chart
     - Jsoup code
     - Discussion on using Jsoup to scrape data
     - Responses to conclusion questions

## Evaluation Forms

- **[Gallery Walk Evaluation Form](https://forms.gle/g1EFfVvgDZkNg1426)**:
  - Half of the class will present at a time.
  - Both team members must demonstrate understanding of the code and verify it works as intended.

- **[Presentation Evaluation Form](https://forms.gle/iJ9ub7SY9mkpNiYYA)**:
  - Use the standard student evaluation form for presentations.

## Jsoup Resources and Tutorials

- [Jsoup Homepage](https://jsoup.org/) - Download page for the jar file and documentation.
- [Jsoup Tutorial on Tutorialspoint](https://www.tutorialspoint.com/jsoup/index.htm)
- [Jsoup Test Page](https://try.jsoup.org/) - Test your Jsoup implementation.

If you find additional helpful tutorials, share them on the **[Jsoup Tutorials Sheet](https://docs.google.com/spreadsheets/d/1euX6B16L-UaqpE_pXTTwRcX2tFj2aHMSuKaFOQibMvo/edit?usp=sharing)**.

## Notes

- Be aware of JavaScript on some websites that might prevent automated scraping. Adjust by:
  - Downloading pages locally.
  - Removing JavaScript.
  - Concatenating multiple pages if needed.

Happy coding and good luck!

