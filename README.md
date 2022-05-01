# MASS FILE RENAMER

A simple tool to rename several files in a folder at once, following a predefined scheme.

## CONFIG FILE

Config files define the scheme by which files are renamed, as well as the file ending of files to rename.

It starts as follows:

``
(format)(example:$0_$1_$2_$3-$4)
(ending)(example:pdf)

``

The format describes your names' format. Do not include the file ending here. The ending describes the file ending of files that should be renamed - files that don't contain this are ignored.

Variables (starting at $0) can be set for each file separately and are declared below the format and ending.

Currently, the types "enum"(for a set of possible values), "number"(for numbers), "inc"(for incrementing values), "string"(for any text) and "date"(for dates) are supported.

Declarations look like this:

``
$1: enum
test,hey,hello
$2: number
10
$3: inc
0
$4: string

$5: date

``

Note that an empty line should follow after "string" and "date" as they do not need parameters.

a full config file would look something like this:

``
(format)(example:$0_$1_$2_$3-$4)
(ending)(example:pdf)
$1: enum
test,hey,hello
$2: number
10
$3: inc
0
$4: string

$5: date
``

## Running the program

(As of current, the program is only available as source code - once it isn't, instructions on how to get it running will be here)
