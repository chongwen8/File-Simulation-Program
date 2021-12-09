# File-Simulation-Program
 
This is a file system simulation program simulating the basic service functions of the file system by using one part of memory as virtual disk space. It's function includes creating files, opening files, deleting files, reading files, writing files, etc. 

Each file is described by an FCB or (FCB+inode), the content of which can be set according to the specific situation. The external memory allocation using continuous allocation strategy (or other strategies, one of your choice), that is, the external memory space to be allocated for the file when creating the file, and the external memory space to be reclaimed when deleting the file.
The program can view or the free and occupied disk space and the basic information of the file during the running process in order to observe the file management.
