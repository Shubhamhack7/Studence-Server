#!/bin/bash

# Check if script is run with sudo
if [[ $(id -u) -ne 0 ]]; then
  echo "This script requires sudo permission. Please run it with sudo or as root."
  exit 1
fi

# Maven project directory
project_dir="/home/tiwaritiwari/Studence/Studence-Server"

# Base package
base_package="com.tiwari.studence"

# Folder types
folder_types=("convertor" "updater" "indexer" "servlet" "module" "provider" "searcher" "service" "injector")

# Read module name from user input
read -p "Enter module name: " module_name

# Validate module name
if [[ -z "$module_name" ]]; then
  echo "Module name cannot be empty."
  exit 1
fi

# Check if module name contains "studence-" prefix
prefix="studence-"
if [[ $module_name != $prefix* ]]; then
  echo "Module name should start with 'studence-'."
  exit 1
fi

# Remove the prefix from module name
module_name=${module_name#$prefix}

# Append module name to project directory
project_dir="${project_dir}/${prefix}${module_name}"

echo "Creating module '${module_name}'..."

# Create module folder
mkdir -p "$project_dir"

# Create pom.xml for the module
pom_template="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"$'\n'
pom_template+="<project xmlns=\"http://maven.apache.org/POM/4.0.0\""$'\n'
pom_template+="         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""$'\n'
pom_template+="         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">"$'\n'
pom_template+="    <modelVersion>4.0.0</modelVersion>"$'\n'
pom_template+="    <groupId>${base_package}</groupId>"$'\n'
pom_template+="    <artifactId>${prefix}${module_name}</artifactId>"$'\n'
pom_template+="    <version>0.0.1-SNAPSHOT</version>"$'\n'
pom_template+="    <name>${prefix}${module_name}</name>"$'\n'
pom_template+="    <url>http://www.example.com</url>"$'\n'
pom_template+="    <properties>"$'\n'
pom_template+="        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>"$'\n'
pom_template+="        <maven.compiler.source>1.7</maven.compiler.source>"$'\n'
pom_template+="        <maven.compiler.target>1.7</maven.compiler.target>"$'\n'
pom_template+="    </properties>"$'\n'
pom_template+="    <dependencies>"$'\n'
pom_template+="        <dependency>"$'\n'
pom_template+="            <groupId>${base_package}</groupId>"$'\n'
pom_template+="            <artifactId>studence-common-http</artifactId>"$'\n'
pom_template+="            <version>0.0.1-SNAPSHOT</version>"$'\n'
pom_template+="        </dependency>"$'\n'
pom_template+="        <dependency>"$'\n'
pom_template+="            <groupId>javax.servlet</groupId>"$'\n'
pom_template+="            <artifactId>javax.servlet-api</artifactId>"$'\n'
pom_template+="            <version>4.0.1</version>"$'\n'
pom_template+="            <scope>provided</scope>"$'\n'
pom_template+="        </dependency>"$'\n'
pom_template+="        <dependency>"$'\n'
pom_template+="            <groupId>jakarta.servlet</groupId>"$'\n'
pom_template+="            <artifactId>jakarta.servlet-api</artifactId>"$'\n'
pom_template+="            <version>6.0.0</version>"$'\n'
pom_template+="            <scope>provided</scope>"$'\n'
pom_template+="        </dependency>"$'\n'
pom_template+="        <dependency>"$'\n'
pom_template+="            <groupId>${base_package}</groupId>"$'\n'
pom_template+="            <artifactId>studence-common</artifactId>"$'\n'
pom_template+="            <version>0.0.1-SNAPSHOT</version>"$'\n'
pom_template+="        </dependency>"$'\n'
pom_template+="    </dependencies>"$'\n'
pom_template+="   <build>"$'\n'
pom_template+="    <pluginManagement>"$'\n'
pom_template+="			<!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent"$'\n'
pom_template+="				pom) -->"$'\n'
pom_template+="			<plugins>"$'\n'
pom_template+="				<!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle"$'\n'
pom_template+="					-->"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>exec-maven-plugin</artifactId>"$'\n'
pom_template+="					<version>3.1.0</version>"$'\n'
pom_template+="					<groupId>org.codehaus.mojo</groupId>"$'\n'
pom_template+="					<executions>"$'\n'
pom_template+="						<execution>"$'\n'
pom_template+="							<id>my-exec</id>"$'\n'
pom_template+="							<phase>pre-integration-test</phase>"$'\n'
pom_template+="							<goals>"$'\n'
pom_template+="								<goal>exec</goal>"$'\n'
pom_template+="							</goals>"$'\n'
pom_template+="						</execution>"$'\n'
pom_template+="					</executions>"$'\n'
pom_template+="					<configuration>"$'\n'
pom_template+="						<executable>bash</executable>"$'\n'
pom_template+="						<commandlineArgs>../complieproto.sh</commandlineArgs>"$'\n'
pom_template+="					</configuration>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-clean-plugin</artifactId>"$'\n'
pom_template+="					<version>3.1.0</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging"$'\n'
pom_template+="					-->"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-resources-plugin</artifactId>"$'\n'
pom_template+="					<version>3.0.2</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<groupId>org.apache.maven.plugins</groupId>"$'\n'
pom_template+="					<artifactId>maven-compiler-plugin</artifactId>"$'\n'
pom_template+="					<configuration>"$'\n'
pom_template+="						<source>1.8</source>"$'\n'
pom_template+="						<target>1.8</target>"$'\n'
pom_template+="					</configuration>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-surefire-plugin</artifactId>"$'\n'
pom_template+="					<version>2.22.1</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-jar-plugin</artifactId>"$'\n'
pom_template+="					<version>3.0.2</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-install-plugin</artifactId>"$'\n'
pom_template+="					<version>2.5.2</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-deploy-plugin</artifactId>"$'\n'
pom_template+="					<version>2.8.2</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle"$'\n'
pom_template+="					-->"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-site-plugin</artifactId>"$'\n'
pom_template+="					<version>3.7.1</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="				<plugin>"$'\n'
pom_template+="					<artifactId>maven-project-info-reports-plugin</artifactId>"$'\n'
pom_template+="					<version>3.0.0</version>"$'\n'
pom_template+="				</plugin>"$'\n'
pom_template+="			</plugins>"$'\n'
pom_template+="		</pluginManagement>"$'\n'
pom_template+="  </build>"$'\n'
pom_template+="</project>"$'\n'

pom_file_path="${project_dir}/pom.xml"
echo "$pom_template" > "$pom_file_path"

# Read folder types and generate classes
for folder_type in "${folder_types[@]}"; do
  # Generate class name based on folder type
  class_name="${module_name^}${folder_type^}"

  echo "Creating directory: ${module_name}/${folder_type}..."

  # Create package folder
  package_folder_path="${project_dir}/src/main/java/${base_package//./\/}/${module_name}/${folder_type}"
  mkdir -p "$package_folder_path"

  echo "Creating Java class: ${base_package}.${folder_type}.${class_name}..."

  # Create Java class
  java_class_path="${package_folder_path}/${class_name}.java"
  echo "package ${base_package}.${module_name}.${folder_type};" > "$java_class_path"
  echo "" >> "$java_class_path"
  echo "public class ${class_name} {" >> "$java_class_path"
  echo "" >> "$java_class_path"
  echo "    // TODO: Implement ${class_name}" >> "$java_class_path"
  echo "" >> "$java_class_path"
  echo "}" >> "$java_class_path"

  # Commit the changes using Git
  git add "$project_dir"
  git commit -m "Add ${module_name} module and ${class_name} class"
done

# Update the top-level pom.xml with the module name
top_level_pom="${project_dir}/../pom.xml"
sed -i "/<modules>/a\        <module>${prefix}${module_name}</module>" "$top_level_pom"

if [[ $? -eq 0 ]]; then
  echo "Module '${module_name}' created successfully."
else
  echo "An error occurred while creating the module. Rolling back changes..."
  rm -rf "$project_dir"
  exit 1
fi

