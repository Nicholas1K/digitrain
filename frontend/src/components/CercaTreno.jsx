import React from "react";
import {
  Paper,
  Box,
  Grid,
  Typography,
  TextField,
  Button,
  FormControl,
  Select,
  MenuItem,
} from "@mui/material";

const CercaTreno = ({ onSubmit }) => {
  const [travel, setTravel] = React.useState({
    departureCity: "",
    arrivalCity: "",
    departureTime: "",
  });

  const [travelError, setTravelError] = React.useState({
    departureCity: true,
    arrivalCity: true,
    departureTime: true,
  });

  const handleTravelChange = (e) => {
    const { name, value } = e.target;

    setTravel({
      ...travel,
      [name]: value,
    });

    setTravelError({
      ...travelError,
      [name]: value.length < 1,
    });
  };

  const [isDisabled, setIsDisabled] = React.useState(true);

  React.useEffect(() => {
    setIsDisabled(
      !Object.values(travelError).every((value) => value === false)
    );
  }, [travelError]);

  const handleSubmit = () => {
    onSubmit(travel);
  };

  return (
    <Box mb={3}>
      <Paper>
        <Box p={2}>
          <Grid
            container
            direction="row"
            justifyContent="center"
            alignItems="center"
            spacing={2}
          >
            <Grid item xs={12} sm={4}>
              <Typography>Città di partenza</Typography>
              <FormControl fullWidth error={travelError.departureCity}>
                <Select
                  value={travel.departureCity}
                  label="Città di partenza"
                  name="departureCity"
                  onChange={handleTravelChange}
                  required
                >
                  <MenuItem value="">Seleziona una città</MenuItem>
                  <MenuItem value="Milano">Milano</MenuItem>
                  <MenuItem value="Roma">Roma</MenuItem>
                  <MenuItem value="Bergamo">Bergamo</MenuItem>
                  <MenuItem value="Torino">Torino</MenuItem>
                  <MenuItem value="Venezia">Venezia</MenuItem>
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={4}>
              <Typography>Città di arrivo</Typography>
              <FormControl fullWidth error={travelError.arrivalCity}>
                <Select
                  labelId="arrivalCity"
                  value={travel.arrivalCity}
                  label="Città di Arrivo"
                  name="arrivalCity"
                  onChange={handleTravelChange}
                  required
                >
                  <MenuItem value="">Seleziona una città</MenuItem>
                  <MenuItem value="Milano">Milano</MenuItem>
                  <MenuItem value="Roma">Roma</MenuItem>
                  <MenuItem value="Bergamo">Bergamo</MenuItem>
                  <MenuItem value="Torino">Torino</MenuItem>
                  <MenuItem value="Venezia">Venezia</MenuItem>
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={4}>
              <Typography>Data e ora di partenza</Typography>
              <TextField
                fullWidth
                name="departureTime"
                type="datetime-local"
                value={travel.departureTime}
                error={travelError.departureTime}
                onChange={handleTravelChange}
                required
              />
            </Grid>
            <Grid item xs={4}>
              <Button
                fullWidth
                variant="contained"
                disabled={isDisabled}
                onClick={handleSubmit}
              >
                Cerca
              </Button>
            </Grid>
          </Grid>
        </Box>
      </Paper>
    </Box>
  );
};

export default CercaTreno;
