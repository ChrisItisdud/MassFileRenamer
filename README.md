# MASS FILE RENAMER

A simple tool to rename several files in a folder at once, following a predefined scheme.

## CONFIG FILE

Config files define the scheme by which files are renamed, as well as the file ending of files to rename.

It starts as follows:

```
(format)(example:$0_$1_$2_$3-$4)
(ending)(example:pdf)
```

The format describes your names' format. Do not include the file ending here. The ending describes the file ending of files that should be renamed - files that don't contain this are ignored.

Variables (starting at $0) can be set for each file separately and are declared below the format and ending.

Currently, the types "enum"(for a set of possible values), "number"(for numbers), "inc"(for incrementing values), "string"(for any text) and "date"(for dates) are supported.

Declarations look like this:

```
$1: enum
test,hey,hello
$2: number
10
$3: inc
0
$4: string

$5: date

```

Note that an empty line should follow after "string" and "date" as they do not need parameters.

a full config file would look something like this:

```
$0_$1_$2_$3-$4
pdf
$1: enum
test,hey,hello
$2: number
10
$3: inc
0
$4: string

$5: date

```

## Running the program

To run the program, simply download the newest version from the "Releases" section, write your config file, use a command line (such as windows' cmd) to navigate to the directory you located the jar file in, then run it using the following command:

``java -jar MassFileRenamer-1.0-SNAPSHOT.jar``

The program will then walk you through the renaming process.
