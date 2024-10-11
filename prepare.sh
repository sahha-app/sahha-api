sudo yum update -y
sudo yum install -y docker
sudo yum install git -y
sudo yum install java-17-amazon-corretto-headless -y
sudo wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
tar -xvzf apache-maven-3.9.9-bin.tar.gz
sudo mv apache-maven-3.9.9 /opt/
echo "export M2_HOME=/opt/apache-maven-3.9.9" | sudo tee /etc/profile.d/maven.sh > /dev/null
echo "export PATH=\${M2_HOME}/bin:\${PATH}" | sudo tee -a /etc/profile.d/maven.sh > /dev/null
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh
mvn -version