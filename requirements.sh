sudo apt-get update
echo -n "Do you want to install Java 17 (y/n)? "
read answer
if [ "$answer" != "${answer#[Yy]}" ] ;then
    sudo wget "https://download.oracle.com/java/17/latest/jdk-17_linux-aarch64_bin.tar.gz"
else
    echo OK.
fi
echo -n "Do you want to install Maven (y/n)? "
read answer
if [ "$answer" != "${answer#[Yy]}" ] ;then
    sudo wget "https://dlcdn.apache.org/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz"
else
    echo OK.
fi
