import React from "react";
import { useParams } from "react-router-dom";
import api from "../api";
import Layout from "../components/Layout";
import { Alert, Box, Typography } from "@mui/material";
import { isEmpty } from "lodash";

export default function Prenotazione() {
  const { id } = useParams();
  const [reservation, setReservation] = React.useState();
  const [apiError, setApiError] = React.useState(false);

  React.useEffect(() => {
    api
      .get("/reservation/find/" + id)
      .then((res) => {
        setReservation(res.data);
      })
      .catch((err) => console.log(err));
  }, [id]);

  return (
    <>
      <Layout>
        {apiError && <Alert severity="error">C'è stato un errore</Alert>}
        {!apiError && !isEmpty(reservation) && (
          <Box mb={3}>
            <Typography variant="h3" component="h4" gutterBottom>
              Prenotazione #{reservation.id}
            </Typography>

            <Typography variant="h6">
              Passeggero: {reservation.passenger.name}
            </Typography>
          </Box>
        )}
      </Layout>
    </>
  );
}
