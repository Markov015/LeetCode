# Read from the file file.txt and output the tenth line to stdout.

# grep


# sed
sed -n '10p' file.txt

# awk
awk 'NR==10' file.txt
