#!/bin/bash

# Function to recursively delete a folder (requires sudo)
delete_folder() {
  local folder="$1"
  local target_folder_name="$2"

  # Ensure target folder itself is not deleted
  if [[ "$folder" != "$target_folder_name" ]]; then
    if [[ $(id -u) -eq 0 ]]; then  # Check if running as root
      for file in "$folder"/*; do
        if [[ -d "$file" ]]; then
          delete_folder "$file" "$target_folder_name"
        else
          #rm -f "$file"
          echo "Deleted File: $file"
        fi
      done

     # rmdir "$folder"  # Delete empty folder
      echo "Deleted Folder: $folder"
    else
      echo "Error: Deleting folders requires sudo permissions."
      echo "Run the script with sudo: sudo ./find_delete_target.sh <initial_folder> target"
    fi
  fi
}

# Main script
if [[ "$#" -ne 1 ]]; then
  echo "Usage: $0 <initial_folder>"
  exit 1
fi

initial_folder="$1"
target_folder_name="target"

if [[ ! -d "$initial_folder" ]]; then
  echo "Invalid initial folder: $initial_folder"
  exit 1
fi

# No need for find_target_folder function here

for file in "$initial_folder"/*; do
  if [[ -d "$file" && "$file" != "$target_folder_name" ]]; then
    delete_folder "$file" "$target_folder_name"
  elif [[ "$file" == "$target_folder_name" ]]; then
    echo "Target folder found: $file"
    delete_folder "$file" "$target_folder_name"
  fi
done
