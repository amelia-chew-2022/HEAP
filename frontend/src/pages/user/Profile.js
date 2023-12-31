import { Fragment } from "react";
import HeadingOne from "../../components/common/heading/HeadingOne";
import Grid from "@mui/material/Unstable_Grid2/Grid2";
import HeadingTwo from "../../components/common/heading/HeadingTwo";
import ProfileIllustration from "../../assets/illustrations/user/profile-illustration.jpg";
import FieldsColumn from "../../components/common/form/FieldsColumn";
import TextField from "../../components/common/form/TextField";
import PersonIcon from "@mui/icons-material/Person";
import VpnKeyIcon from "@mui/icons-material/VpnKey";
import SubmitFormGroup from "../../components/common/form/SubmitFormGroup";
import FieldsRow from "../../components/common/form/FieldsRow";
import TextArea from "../../components/common/form/TextArea";
import SingleItemDropdown from "../../components/common/form/SingleItemDropdown";
import { businessType, cuisineType } from "../../constants/dropdown-choices";
import Checkbox from "../../components/common/form/Checkbox";
import { FormProvider, useForm } from "react-hook-form";
import MultiItemDropdown from "../../components/common/form/MultiItemDropdown";
import { useLoaderData, useNavigate } from "react-router-dom";
import updateUser from "../../axios/user/updateUserAPI";

const Profile = () => {
    const { user } = useLoaderData();
    const {
        business,
        email,
    } = user;
    const formMethods = useForm({
        values: { ...business, email: email },
    });
    const navigate = useNavigate();
    console.log("Business isFusion = " + business.isFusion)

    return (
        <Fragment>
            <HeadingOne divider={true}>My Profile</HeadingOne>
            <FormProvider {...formMethods}>
                <Grid container spacing={2}>
                    <Grid xs={6}>
                        <HeadingTwo>User Profile</HeadingTwo>
                        <FieldsColumn>
                            <TextField
                                rules={{
                                    required: true,
                                    pattern:
                                        /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/,
                                }}
                                name="email"
                                label="Email"
                                icon={<PersonIcon />}
                            />{" "}
                            <FieldsRow>
                                <TextField
                                    rules={{ required: false, minLength: 8 }}
                                    name="password"
                                    label="Password"
                                    type="password"
                                    icon={<VpnKeyIcon />}
                                />
                                <TextField
                                    rules={{
                                        required: false,
                                        minLength: 8,
                                        customRules: {
                                            validate: (value, { password }) =>
                                                password === value ||
                                                "Confirm password does not match Password",
                                        },
                                    }}
                                    name="confirmPassword"
                                    label="Confirm Password"
                                    type="password"
                                    icon={<VpnKeyIcon />}
                                />
                            </FieldsRow>
                        </FieldsColumn>

                        <HeadingTwo>Business Details</HeadingTwo>
                        <FieldsColumn>
                            <TextField
                                rules={{ required: true }}
                                name="businessName"
                                label="Name of F&B Business"
                                size="large"
                            />
                            <TextArea
                                rules={{ required: true }}
                                name="storeAddress"
                                label="Store Address"
                            />
                            <TextField
                                rules={{ required: true }}
                                name="postalCode"
                                label="Postal Code"
                                type="number"
                                size="large"
                            />
                        </FieldsColumn>

                        <HeadingTwo>Cuisine Choices</HeadingTwo>
                        <FieldsColumn>
                            <SingleItemDropdown
                                name="businessType"
                                rules={{ required: true }}
                                label="Type of F&B Business"
                                size="large"
                                choices={businessType}
                            />
                            <MultiItemDropdown
                                name="cuisineType"
                                rules={{ required: true }}
                                label="Type of Cuisine"
                                size="large"
                                choices={cuisineType}
                            />
                            <Checkbox name="isFusion" label="Fusion Cuisine?" />
                        </FieldsColumn>
                    </Grid>
                    <Grid xs={6}>
                        <img
                            style={{ width: "100%" }}
                            src={ProfileIllustration}
                            alt="Profile Illustration"
                        />
                    </Grid>
                </Grid>
                <SubmitFormGroup
                    submitText="Update Profile"
                    submitErrorText="Update of profile is unsuccessful, please check your input"
                    onSubmit={async (data) => {
                        const { password, confirmPassword, ...other } = data;
                        const res = await updateUser(
                            password && confirmPassword ? data : other
                        );
                        navigate("/my-summary", {
                            state: { success: res },
                        });
                    }}
                />
            </FormProvider>
        </Fragment>
    );
};

export default Profile;
