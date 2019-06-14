TODO:
Load in Menu. Save button creates a empty jpg file lol.

I tested this app on a macbook

SELENA'S DRAWING APPLICATION:

Menu Items:
New: Empties the canvas of any drawings as long as Rectangle, Circle or Line buttons is not selected.


There are 6 functions/tools you use:
1. Select a Shape
2. Erase a Shape
3. Draw a Rectangle
4. Draw a Circle
5. Draw a Line
6. Fill a Rectangle or Circle

None of the tools are selected when you first start the application. You must click on a button to start....preferably one of the buttons
that allows you to draw shapes.

SELECT TOOL
Once this tool is selected, clicking on a shape will cause the shape border to become dashed to indicate that it is selected.
Pressing ESC key will deselect the selected shape. But the currently selected colour and line thickness will be the same as the shape that
was most recently selected.
Pressing and dragging the selected shape will cause the shape to move around with the mouse.
Icon made by smashicons from www.flaticon.com


ERASER TOOL
Click this tool and click any shape on the canvas will cause the entire shape to be erased. If there are overlaps of the shapes, the shape
that was most recently drawn will be deleted.
Icon made by Pixel Perfect from www.flaticon.com


RECTANGLE TOOL
Click this tool and click and drag on the canvas will create a drawing of a rectangle with the currently selected colour as the outline
(with currently selected thickness) and a transparent background.
Icon made by Freepik from www.flaticon.com


CIRCLE TOOL
Click this tool and click and drag on the canvas will create a drawing of a circle with the currently selected colour
as the outline (with currently selected thickness) and a transparent background.
Icon made by Google from www.flaticon.com


LINE TOOL
Click this tool and click and drag on the canvas will create a drawing of a line with the currently selected colour
as the outline (with currently selected thickness) and a transparent background.
Icon made by Smashicons from www.flaticon.com


FILL TOOL
Click this tool and click a rectangle or circle will fill the shape with the currently selected colour. The border of the shape
stays the same as when you first drew the shape - the border colour will not change with the fill tool.
Clicking this tool and then a line will do nothing.
Icon made by Smashicons from www.flaticon.com


There is a palette of 6 colours:
1. Black
2. Red
3. Blue
4. Yellow
5. Green
6. Pink

The default colour when the application first start is black.

There is also a colour dialog button under the palette of 6 colors. You can choose more colours here.


There are 3 thickness of lines you can choose from - 3px, 6px, 9px. The default is a thickness of 3px.

ADDITIONAL FEATURE:
I implemented the copy to clipboard function. Click on "c" on your keyboard to copy the screen with your application on it. Then you can
check your macbook's clipboard to see that it is there. The code is taken from https://coderanch.com/t/333565/java/BufferedImage-System-Clipboard
