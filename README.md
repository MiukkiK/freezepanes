<h1>Freeze Panes with Wicket</h1>
<p>The application makes a Jetty server at <a href="http://localhost:8080">localhost:8080</a>.</p>
<p>Application holds a table of data that can be edited cell by cell.</p>
<p>The application supports multiple sessions.</p>
<p>The table is prefilled with test data for every user.</p>
<h3>Usage</h3>
<p>Launch from src/test/java/StartFreezePanes.java</p>
<p>Go to localhost:8080</p>
<p>You can test limiting the window size by clicking either "Emulate" link on the top, or reset back to default with the "Default view" button.</p>
<p>Click on a cell to display the textbox for editing.</p>
<p>After changing the text, user can click Save button to save the new text into the selected cell, or cancel to keep the old data.</p>
<p>Edit box is only visible while a cell is selected.</p>
<p>Click "Random edit" to fill a random cell with a random phrase. Phrases are defined in the RandomEditPhrases class. </p>