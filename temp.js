/**
 * Get the organization of an IP address using the IPinfo API.
 *
 * @param {string} ipAddress The IP address you want to look up.
 * @return {string} The organization associated with the IP address.
 * @customfunction
 */
function GET_IP_ORG(ipAddress) {
  if (!ipAddress) {
    return "Invalid IP Address";
  }
  
  // Replace with your IPinfo API key
  const API_KEY = "c9bbd25edb6b3c";
  const API_URL = `https://ipinfo.io/${ipAddress}/org?token=${API_KEY}`;
  
  try {
    // Fetch the IP address information from the API
    const response = UrlFetchApp.fetch(API_URL);
    const data = response.getContentText();

    // Return the organization if available
    return removeBeforeSpace(data) || "Not found";
  } catch (error) {
    // Handle errors (e.g., invalid IP or API issues)
    return `Error: ${error.message}`;
  }
}

function removeBeforeSpace(input) {
  input = input.trim();
  // Find the index of the first space
  const spaceIndex = input.indexOf(' ');
  
  // If no space is found, return the original string
  if (spaceIndex === -1) {
    return input;
  }
  
  // Return the substring after the first space
  return input.substring(spaceIndex + 1).trim();
}
