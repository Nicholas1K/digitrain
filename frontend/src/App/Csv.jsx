import React from "react";
import Layout from "../components/Layout";
import { Box, Button, Typography } from "@mui/material";
import axios from "axios";
import api from "../api";

export default function CSV() {
  const [file, setFile] = React.useState(null);

  const handleSubmit = () => {
    const formData = new FormData();
    formData.append("file", file);

    api
      .post("/csv/upload-csv-data", formData)
      .then((res) => console.log(res))
      .catch((err) => console.log(err));
  };

  return (
    <>
      <Layout>
        <Box mb={3}>
          <Typography variant="h3" component="h4" gutterBottom>
            Carica CSV
          </Typography>

          <input
            type="file"
            name="csv"
            id="csv"
            onChange={(e) => setFile(e.target.files[0])}
          />

          <Button onClick={handleSubmit}>Salva</Button>
        </Box>
      </Layout>
    </>
  );
}
